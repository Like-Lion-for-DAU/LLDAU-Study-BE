# 멤버 및 과제 관리 시스템

## 프로젝트 소개

Spring Boot와 Spring Data JPA를 활용하여 전역 예외 처리와 API 기반의 멤버 및 과제 관리 시스템입니다.
이 프로젝트는 커스텀 예외, `@RestControllerAdvice`를 통한 전역 에러 처리, 그리고 Spring Data JPA의 쿼리 메서드를 학습하기 위한 교육용 프로젝트입니다.

## 기술 스택

- **Language**: Java 17+
- **Framework**: Spring Boot 3.x
- **ORM**: Spring Data JPA
- **Database**: MySQL
- **Build Tool**: Gradle
- **Frontend**: HTML, CSS, JavaScript

## 실행 방법

### 1. 환경 설정

```bash
# 데이터베이스 생성
CREATE DATABASE likelion_pbl CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. application.properties 설정

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/likelion_pbl
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. 애플리케이션 실행

```bash
./gradlew bootRun
```

### 4. 브라우저 접속

```
http://localhost:8080
```

## API 목록

### 멤버 API

| HTTP 메서드 | URI | 설명 |
| --- | --- | --- |
| `GET` | `/members` | 전체 멤버 조회 |
| `GET` | `/members?part=백엔드` | 파트별 멤버 필터링 |
| `GET` | `/members/{id}` | 멤버 단건 조회 |
| `POST` | `/members/lions` | 아기사자 멤버 등록 |
| `POST` | `/members/staffs` | 스태프 멤버 등록 |
| `PUT` | `/members/lions/{id}` | 아기사자 멤버 수정 |
| `PUT` | `/members/staffs/{id}` | 스태프 멤버 수정 |
| `DELETE` | `/members/{id}` | 멤버 삭제 |

### 과제 API

| HTTP 메서드 | URI | 설명 |
| --- | --- | --- |
| `POST` | `/members/{memberId}/assignments` | 과제 등록 |
| `GET` | `/assignments` | 전체 과제 조회 |
| `GET` | `/assignments?keyword=검색어` | 과제 제목 검색 |
| `GET` | `/assignments/{id}` | 과제 단건 조회 |
| `GET` | `/members/{memberId}/assignments` | 멤버별 과제 조회 |
| `PUT` | `/assignments/{id}` | 과제 수정 |
| `DELETE` | `/assignments/{id}` | 과제 삭제 |

## 프로젝트 구조

```
src/main/java/com/lielion/PBL/
├── member/
│   ├── controller/
│   │   └── MemberController.java           # 멤버 API 엔드포인트
│   ├── service/
│   │   └── MemberService.java              # 멤버 비즈니스 로직
│   ├── repository/
│   │   └── MemberRepository.java           # 멤버 데이터 접근
│   ├── domain/
│   │   ├── Member.java                     # 멤버 엔티티
│   │   └── RoleType.java                   # 역할 타입 (LION, STAFF)
│   └── dto/
│       ├── LionCreateRequest.java          # 아기사자 등록 요청
│       ├── StaffCreateRequest.java         # 스태프 등록 요청
│       ├── LionUpdateRequest.java          # 아기사자 수정 요청
│       ├── StaffUpdateRequest.java         # 스태프 수정 요청
│       └── MemberResponse.java             # 멤버 응답
├── assignment/
│   ├── controller/
│   │   └── AssignmentController.java       # 과제 API 엔드포인트
│   ├── service/
│   │   └── AssignmentService.java          # 과제 비즈니스 로직
│   ├── repository/
│   │   └── AssignmentRepository.java       # 과제 데이터 접근
│   ├── domain/
│   │   └── Assignment.java                 # 과제 엔티티
│   └── dto/
│       ├── AssignmentCreateRequest.java    # 과제 등록 요청
│       ├── AssignmentUpdateRequest.java    # 과제 수정 요청
│       └── AssignmentResponse.java         # 과제 응답
└── global/
    ├── exception/
    │   ├── GlobalExceptionHandler.java     # 전역 예외 처리
    │   ├── MemberNotFoundException.java    # 멤버 미존재 예외
    │   ├── AssignmentNotFoundException.java# 과제 미존재 예외
    │   └── DuplicateMemberException.java   # 중복 멤버 예외
    └── dto/
        └── ErrorResponse.java              # 에러 응답 DTO

src/main/resources/
└── static/
    ├── index.html                          # 메인 페이지
    ├── css/
    │   └── style.css                       # 스타일시트
    └── js/
        ├── member.js                       # 멤버 API 클라이언트
        └── assignment.js                   # 과제 API 클라이언트
```

## 주요 학습 포인트

### 1. 전역 예외 처리 (@RestControllerAdvice)

- `@RestControllerAdvice`로 모든 컨트롤러의 예외를 한 곳에서 처리
- `@ExceptionHandler`를 사용하여 특정 예외에 대한 응답 정의
- 일관된 에러 응답 형식 제공

### 2. 커스텀 예외

- `RuntimeException`을 상속한 비즈니스 로직 예외 생성
- 서비스에서 null 대신 예외 던지기 (fail-fast 원칙)
- 컨트롤러에서 null 체크 불필요

### 3. Spring Data JPA 쿼리 메서드

- `findByPart(String part)`: 파트별 멤버 조회
- `findByName(String name)`: 이름으로 멤버 조회
- `findByTitleContaining(String keyword)`: 제목 검색

### 4. HTTP 메서드와 CRUD

- `GET`: Read (조회)
- `POST`: Create (생성)
- `PUT`: Update (수정)
- `DELETE`: Delete (삭제)

## 테스트 시나리오

### 멤버 관리

1. 아기사자 등록 → 멤버 목록 조회 → 파트별 필터링
2. 스태프 등록 → 이름 중복 확인
3. 멤버 수정 및 삭제

### 과제 관리

1. 과제 등록 → 전체 조회
2. 멤버별 과제 조회
3. 제목 검색
4. 과제 수정 및 삭제

### 에러 처리

1. 존재하지 않는 ID로 조회 (404 Not Found)
2. 중복 이름으로 등록 (409 Conflict)
3. 유효하지 않은 멤버 ID로 과제 등록 (404 Not Found)
