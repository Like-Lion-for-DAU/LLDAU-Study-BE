# Likelion Member Manager

Member와 Assignment를 관리하는 Spring Boot 기반 CRUD 실습 프로젝트입니다. 10주차에서는 전역 예외 처리, 검색 API, 전체 과제 조회 API, 정적 프론트엔드 연동을 추가했습니다.

## 기술 스택

- Java 17
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- MySQL Connector/J
- MySQL

## 실행 방법

1. MySQL에서 데이터베이스를 생성합니다.

```sql
CREATE DATABASE likelion_pbl;
```

2. MySQL 계정 정보를 환경 변수로 설정합니다.

```bash
MYSQL_USERNAME=root
MYSQL_PASSWORD=비밀번호
```

3. 프로젝트를 실행합니다.

```bash
./gradlew bootRun
```

Windows에서는 다음 명령을 사용할 수 있습니다.

```bash
gradlew.bat bootRun
```

4. 브라우저에서 접속합니다.

```text
http://localhost:8080
```

## API 목록

### Member API

| HTTP 메서드 | URI | 설명 |
| --- | --- | --- |
| POST | `/members/lions` | 아기사자 멤버 등록 |
| POST | `/members/staffs` | 운영진 멤버 등록 |
| GET | `/members` | 전체 멤버 조회 |
| GET | `/members?part=` | 파트별 멤버 필터링 |
| GET | `/members/{id}` | 멤버 단건 조회 |
| PUT | `/members/lions/{id}` | 아기사자 멤버 수정 |
| PUT | `/members/staffs/{id}` | 운영진 멤버 수정 |
| DELETE | `/members/{id}` | 멤버 삭제 |

### Assignment API

| HTTP 메서드 | URI | 설명 |
| --- | --- | --- |
| POST | `/members/{memberId}/assignments` | 특정 멤버의 과제 등록 |
| GET | `/assignments` | 전체 과제 조회 |
| GET | `/members/{memberId}/assignments` | 멤버별 과제 조회 |
| GET | `/assignments/{id}` | 과제 단건 조회 |
| GET | `/assignments/search?keyword=` | 과제 제목 검색 |
| PUT | `/assignments/{id}` | 과제 수정 |
| DELETE | `/assignments/{id}` | 과제 삭제 |

## 에러 응답

모든 커스텀 예외는 `GlobalExceptionHandler`에서 공통 JSON 형식으로 응답합니다.

```json
{
  "status": 404,
  "message": "존재하지 않는 과제입니다. id=9999"
}
```

| 예외 | 상태 코드 | 상황 |
| --- | --- | --- |
| `MemberNotFoundException` | 404 | 존재하지 않는 멤버 조회, 수정, 삭제 |
| `AssignmentNotFoundException` | 404 | 존재하지 않는 과제 조회, 수정, 삭제 |
| `DuplicateMemberException` | 409 | 이미 등록된 이름으로 멤버 등록 |

## 프로젝트 구조

```text
src/main/java/com/lielion/PBL
├── member
│   ├── controller
│   ├── service
│   ├── repository
│   ├── domain
│   └── dto
├── assignment
│   ├── controller
│   ├── service
│   ├── repository
│   ├── domain
│   └── dto
└── global
    ├── exception
    └── dto

src/main/resources
└── static
    ├── index.html
    ├── css/style.css
    └── js
        ├── member.js
        └── assignment.js
```
