# catlendar  
프로젝트 개요 (2024.01.17~)
#### 1. 서버 환경 구성
  - AWS EC2 서버 증설 및 운영체제, 관리자 권한 설정
#### 2. 데이터베이스 설정
  - MariaDB 도입 및 관련 설정 추가
  - 데이터베이스 관리 도구: 디비버
#### 3. 협업 환경 설정
  - IntelliJ 프로젝트와 GitHub 연동
  - 협업 관리 도구: 소스트리, 노션
#### 4. 애플리케이션 구성 설정
  - application.properties 파일에 데이터베이스 연결, JPA, 코드 자동 재시작 설정 추가
#### 5. 규칙
  - 데이터베이스 테이블과 컬럼명은 스네이크 케이스를 사용
  - 클래스명, 메소드명은 카멜 케이스를 따르며, 변수명은 소문자로 시작하여 카멜 케이스를 사용
  - 스네이크 케이스 작성의 번거로움을 방지하기 위해 mybatis mapUnderscoreToCamelCase 세팅 필요
  - 구현한 기능에 대해서는 주석 작성
#### 6. 개발 환경
```
  운영체제: Ubuntu, 관리자 권한: root
  언어: Java
  DB: MariaDB 11.2.2
  JDK: 11
  IDE: IntelliJ
  Framework:
  Spring 5.3.23
  Spring Boot 2.7.5
  Mybatis 2.2.0
  빌드 도구: Gradle 8.5
  프로젝트 구성 도구: Lombok
```
