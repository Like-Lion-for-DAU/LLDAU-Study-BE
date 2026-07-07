# Demo

## 프로젝트 소개

멤버와 과제를 등록, 조회, 수정, 삭제할 수 있는 Spring Boot 기반 REST API 프로젝트입니다. 멤버별 과제 관리, 파트별 멤버 조회, 과제 제목 검색 기능을 제공합니다.

## 기술 스택

| 구분 | 기술 | 버전 |
| --- | --- | --- |
| Language | Java | 21 |
| Framework | Spring Boot | 4.0.6 |
| Web | Spring Web MVC | Spring Boot 관리 버전 |
| ORM | Spring Data JPA | Spring Boot 관리 버전 |
| Database | H2, MySQL Driver | Spring Boot 관리 버전 |
| Build Tool | Gradle Wrapper | 9.6.0 |
| Library | Lombok | Spring Boot 관리 버전 |

## 실행 방법

```bash
git clone <repository-url>
cd demo
```

```bash
./gradlew bootRun
```

Windows PowerShell에서는 아래 명령을 사용합니다.

```powershell
.\gradlew.bat bootRun
```

실행 후 브라우저에서 정적 테스트 페이지를 확인할 수 있습니다.

```text
http://localhost:8080/
```

MySQL을 사용할 경우 `application.properties`의 datasource 설정을 MySQL 접속 정보로 변경하고, 실행 전에 사용할 데이터베이스를 생성해야 합니다.

```sql
CREATE DATABASE likelion_pbl;
```

## API 목록

### Member API

| HTTP Method | URI | 설명 |
| --- | --- | --- |
| GET | `/members` | 전체 멤버 목록을 조회합니다. `part` 쿼리 파라미터가 있으면 해당 파트 멤버만 조회합니다. |
| POST | `/members/lions` | 아기사자 멤버를 등록합니다. |
| POST | `/members/staffs` | 운영진 멤버를 등록합니다. |
| GET | `/members/{id}` | ID로 멤버 단건을 조회합니다. |
| PUT | `/members/lions/{id}` | 아기사자 멤버 정보를 수정합니다. |
| PUT | `/members/staffs/{id}` | 운영진 멤버 정보를 수정합니다. |
| DELETE | `/members/{id}` | ID로 멤버를 삭제합니다. |

### Assignment API

| HTTP Method | URI | 설명 |
| --- | --- | --- |
| POST | `/members/{memberId}/assignments` | 특정 멤버에게 과제를 등록합니다. |
| GET | `/members/{memberId}/assignments` | 특정 멤버의 과제 목록을 조회합니다. |
| GET | `/assignments` | 전체 과제 목록을 조회합니다. |
| GET | `/assignments/search?keyword={keyword}` | 제목에 키워드가 포함된 과제를 검색합니다. |
| GET | `/assignments/{id}` | ID로 과제 단건을 조회합니다. |
| PUT | `/assignments/{id}` | 과제 정보를 수정합니다. |
| DELETE | `/assignments/{id}` | ID로 과제를 삭제합니다. |

## 프로젝트 구조

```text
src/main/java/com/example/demo
├── DemoApplication.java
├── assignment
│   ├── controller
│   ├── domain
│   ├── dto
│   ├── repository
│   └── service
├── global
│   ├── dto
│   └── exception
└── member
    ├── Controller
    ├── Repository
    ├── Service
    ├── domain
    └── dto

src/main/resources
├── application.properties
└── static
    ├── index.html
    ├── css
    └── js
```

| 패키지 | 역할 |
| --- | --- |
| `assignment.controller` | 과제 관련 HTTP 요청을 받고 정상 응답을 반환합니다. |
| `assignment.domain` | 과제 JPA 엔티티를 관리합니다. |
| `assignment.dto` | 과제 요청/응답 DTO를 관리합니다. |
| `assignment.repository` | 과제 데이터 접근을 담당합니다. |
| `assignment.service` | 과제 등록, 조회, 수정, 삭제, 검색 비즈니스 로직을 담당합니다. |
| `global.dto` | 공통 응답 DTO를 관리합니다. |
| `global.exception` | 커스텀 예외와 전역 예외 처리를 담당합니다. |
| `member.Controller` | 멤버 관련 HTTP 요청을 받고 정상 응답을 반환합니다. |
| `member.Repository` | 멤버 데이터 접근을 담당합니다. |
| `member.Service` | 멤버 등록, 조회, 수정, 삭제 비즈니스 로직을 담당합니다. |
| `member.domain` | 멤버 JPA 엔티티와 역할 타입을 관리합니다. |
| `member.dto` | 멤버 요청/응답 DTO를 관리합니다. |
| `static` | 브라우저에서 사용할 간단한 테스트 화면과 JS/CSS 리소스를 제공합니다. |
