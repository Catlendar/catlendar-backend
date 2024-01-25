package com.catlendar.config;

import com.catlendar.app.user.service.UserService;
import com.catlendar.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final UserService userService;
    @Value("${jwt.secret}")
    private final String secretKey;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
    log.info("authorization:{}",authorization);

    //토큰 없을 시 에러
    if(authorization==null || !authorization.startsWith("Bearer ")){
        log.error("authorization 잘못 보냈습니다.");
        filterChain.doFilter(request, response);
        return;
    }
    //토큰 꺼내기
    String token = authorization.split(" ")[1];

    //토큰 만료 되었는지 여부 확인
    if(JwtUtil.isExpired(token, secretKey)){
        log.error("토큰이 만료 되었습니다.");
        filterChain.doFilter(request, response);
        return;
    }

    // name Token에서 꺼내기
    String name = JwtUtil.getName(token, secretKey);
    log.info("name:{}",name);

    // 권한 부여
    UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(name, null, List.of(new SimpleGrantedAuthority("USER")));

    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
