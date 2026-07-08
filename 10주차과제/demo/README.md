# Likelion Member & Assignment Manager

멋쟁이사자처럼 PBL 백엔드 수업 실습용 Spring Boot 프로젝트입니다. 멤버(LION/STAFF)와 과제를 등록, 조회, 수정, 삭제하고 전역 예외 처리를 통해 일관된 에러 응답을 제공합니다.

## 기술 스택

| 구분 | 기술 |
| --- | --- |
| Language | Java 19 |
| Framework | Spring Boot 4.0.6 |
| Web | Spring Web |
| ORM | Spring Data JPA, Hibernate |
| Database | MySQL |
| Build Tool | Gradle |
| Frontend | HTML, CSS, JavaScript |

## 실행 방법

### 1. 프로젝트 클론

```bash
git clone <repository-url>
cd demo
```

### 2. MySQL 데이터베이스 생성

MySQL에서 아래 데이터베이스를 생성합니다.

```sql
CREATE DATABASE likelion_pbl;
```

### 3. DB 접속 정보 설정

`src/main/resources/application.properties`에서 본인 MySQL 환경에 맞게 설정합니다.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/likelion_pbl
spring.datasource.username=root
spring.datasource.password=your-password
```

현재 프로젝트는 실행 시 테이블을 새로 생성하도록 설정되어 있습니다.

```properties
spring.jpa.hibernate.ddl-auto=create
```

### 4. 애플리케이션 실행

```bash
./gradlew bootRun
```

서버가 정상 실행되면 브라우저에서 아래 주소로 접속합니다.

```text
http://localhost:8080
```

Spring Boot는 `src/main/resources/static/index.html` 파일을 정적 리소스로 제공합니다.

## API 목록

### Member API

| HTTP 메서드 | URI | 설명 |
| --- | --- | --- |
| `POST` | `/members/lions` | 아기사자 멤버 등록 |
| `POST` | `/members/staffs` | 운영진 멤버 등록 |
| `GET` | `/members` | 전체 멤버 조회 |
| `GET` | `/members?part={part}` | 파트별 멤버 조회 |
| `GET` | `/members/{id}` | 멤버 단건 조회 |
| `PUT` | `/members/lions/{id}` | 아기사자 멤버 수정 |
| `PUT` | `/members/staffs/{id}` | 운영진 멤버 수정 |
| `DELETE` | `/members/{id}` | 멤버 삭제 |

### Assignment API

| HTTP 메서드 | URI | 설명 |
| --- | --- | --- |
| `POST` | `/members/{memberId}/assignments` | 특정 멤버에게 과제 등록 |
| `GET` | `/assignments` | 전체 과제 조회 |
| `GET` | `/members/{memberId}/assignments` | 특정 멤버의 과제 목록 조회 |
| `GET` | `/assignments/{id}` | 과제 단건 조회 |
| `GET` | `/assignments/search?keyword={keyword}` | 과제 제목 키워드 검색 |
| `PUT` | `/assignments/{id}` | 과제 수정 |
| `DELETE` | `/assignments/{id}` | 과제 삭제 |

## 에러 응답 형식

전역 예외 처리기는 커스텀 예외를 잡아 아래 형식의 JSON을 반환합니다.

```json
{
  "status": 404,
  "message": "멤버를 찾을 수 없습니다."
}
```

| 예외 상황 | 상태 코드 | 메시지 예시 |
| --- | --- | --- |
| 존재하지 않는 멤버 조회 | `404 Not Found` | `멤버를 찾을 수 없습니다.` |
| 존재하지 않는 과제 조회 | `404 Not Found` | `과제를 찾을 수 없습니다.` |
| 중복된 멤버 이름 등록 | `409 Conflict` | `이미 존재하는 멤버 이름입니다.` |

## 프로젝트 구조

```text
src/main/java/com/example/demo
├── DemoApplication.java
└── class5
    ├── assignment
    │   ├── controller
    │   │   └── AssignmentController.java
    │   ├── dto
    │   │   ├── AssignmentCreateRequest.java
    │   │   ├── AssignmentResponse.java
    │   │   └── AssignmentUpdateRequest.java
    │   ├── repository
    │   │   └── AssignmentRepository.java
    │   └── service
    │       └── AssignmentService.java
    ├── controller
    │   ├── HelloController.java
    │   └── MemberController.java
    ├── domain
    │   ├── Assignment.java
    │   ├── Member.java
    │   └── RoleType.java
    ├── dto
    │   ├── LionCreateRequest.java
    │   ├── LionUpdateRequest.java
    │   ├── MemberResponse.java
    │   ├── StaffCreateRequest.java
    │   └── StaffUpdateRequest.java
    ├── global
    │   ├── dto
    │   │   └── ErrorResponse.java
    │   └── exception
    │       ├── AssignmentNotFoundException.java
    │       ├── DuplicateMemberException.java
    │       ├── GlobalExceptionHandler.java
    │       └── MemberNotFoundException.java
    ├── repository
    │   └── MemberRepository.java
    └── service
        └── MemberService.java
```

| 패키지 | 역할 |
| --- | --- |
| `domain` | JPA 엔티티와 역할 enum 관리 |
| `dto` | 멤버 요청/응답 DTO 관리 |
| `controller` | HTTP 요청을 받아 Service 호출 후 응답 반환 |
| `service` | 비즈니스 로직과 예외 처리 흐름 담당 |
| `repository` | Spring Data JPA를 통한 DB 접근 |
| `assignment` | 과제 관련 Controller, Service, Repository, DTO 관리 |
| `global.dto` | 공통 에러 응답 DTO 관리 |
| `global.exception` | 커스텀 예외와 전역 예외 처리 관리 |

## 정적 프론트엔드 구조

```text
src/main/resources/static
├── index.html
├── css
│   └── style.css
└── js
    ├── assignment.js
    └── member.js
```

프론트엔드는 JavaScript `fetch()`를 사용해 백엔드 API를 호출하며, 화면 하단의 HTTP 통신 로그 패널에서 요청 URL, HTTP 메서드, 상태 코드, 요청/응답 본문을 확인할 수 있습니다.
