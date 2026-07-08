# 백엔드 스터디

## 프로젝트 소개

멤버와 과제를 관리하는 Spring Boot 백엔드 실습 프로젝트

## 기술 스택

```
Java 19
Spring Boot 4.0.6
Spring Web
Spring Data JPA
Hibernate
MySQL
Gradle
HTML/CSS/JavaScript
```
---

## 사용 방법

1. Spring Boot 애플리케이션을 실행한다.

```bash
./gradlew bootRun
```

2. 브라우저에서 `http://localhost:8080`에 접속한다.

---

## API 목록

```
POST   /members/lions
POST   /members/staffs
GET    /members
GET    /members?part=백엔드
GET    /members/{id}
PUT    /members/lions/{id}
PUT    /members/staffs/{id}
DELETE /members/{id}

POST   /members/{memberId}/assignments
GET    /assignments
GET    /members/{memberId}/assignments
GET    /assignments/{id}
GET    /assignments/search?keyword=검색어
PUT    /assignments/{id}
DELETE /assignments/{id}
```

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
        
        
| 패키지 | 역할 |
| `com.example.demo` | Spring Boot 애플리케이션 시작 클래스가 위치 |
| `class5.domain` | `Member`, `Assignment` 같은 JPA 엔티티와 `RoleType` enum 관리 |
| `class5.dto` | 멤버 등록/수정 요청 DTO와 멤버 응답 DTO 관리 |
| `class5.controller` | 멤버 관련 HTTP 요청을 받아 Service를 호출하고 응답 반환 |
| `class5.service` | 멤버 관련 비즈니스 로직 처리 |
| `class5.repository` | 멤버 데이터베이스 접근 담당 |
| `class5.assignment.controller` | 과제 관련 HTTP 요청 처리 |
| `class5.assignment.dto` | 과제 등록/수정 요청 DTO와 과제 응답 DTO 관리 |
| `class5.assignment.service` | 과제 관련 비즈니스 로직 처리 |
| `class5.assignment.repository` | 과제 데이터베이스 접근 담당 |
| `class5.global.dto` | 공통 에러 응답 DTO 관리 |
| `class5.global.exception` | 커스텀 예외와 전역 예외 처리 클래스 관리 |
```

