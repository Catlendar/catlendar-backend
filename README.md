# catlendar  
프로젝트 개요 (2024.01.17~)
#### 1. 서버 환경 구성
  - AWS EC2 서버 증설 및 운영체제, 관리자 권한 설정
#### 2. 데이터베이스 설정
  - MariaDB 도입 및 관련 설정 추가
#### 3. 협업 환경 설정
  - GitHub, notion
#### 4. 규칙
  - 데이터베이스 테이블과 컬럼명은 스네이크 케이스를 사용
  - 클래스명, 메소드명은 카멜 케이스를 따르며, 변수명은 소문자로 시작하여 카멜 케이스를 사용
  - 스네이크 케이스 작성의 번거로움을 방지하기 위해 mybatis mapUnderscoreToCamelCase 세팅 필요
  - 구현한 기능에 대해서는 주석 작성
#### 5. 개발 환경
```
  - Cloud
  서비스: AWS
  운영체제: Ubuntu
  인스턴스 유형: EC2 t2.micro
  스토리지: 30GB

  - BackEnd
  언어: Java
  DB: MariaDB 11.2.2
  JDK: 11
  프레임워크:
  Spring 5.3.23
  Spring Boot 2.7.5
  Mybatis 2.2.0
  빌드 도구: Gradle 8.5
  IDE: IntelliJ
  프로젝트 구성 도구: Lombok

  - ProntEnd
  언어: HTML, CSS, TypeScript
  프레임워크: React.js
  IDE: VScode
```
