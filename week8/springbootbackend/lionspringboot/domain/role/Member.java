package com.springbootbackend.lionspringboot.domain.role;


import jakarta.persistence.*;


//@Entity — "이 클래스는 DB 테이블과 매핑되는 객체다"라고 선언
// 이걸 붙이는 순간 Hibernate가 이 클래스를 보고 member 테이블을 만들 수 있게 됨
// 클래스 이름 Member가 테이블 이름 member가 됨

@Entity
public class Member {

    // IDENTITY는 DB가 자동으로 1, 2, 3... 증가시켜 만들어 준다는 뜻(MySQL의 AUTO_INCREMENT).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private int generation;
    private String part;

    //@Enumerated(EnumType.STRING)은 이 Enum을 DB에 글자 그대로 저장하라는 뜻
    // role_type 컬럼에 "LION", "STAFF" 같은 문자열이 들어감 (저장되는 건 상수 이름인 LION/STAFF이고, 괄호 안의 한글 "아기사자"가 아님)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String studentId;  // LION일 때만 값, STAFF는 null
    private String position;   // STAFF일 때만 값, LION은 null

    protected Member() {}  // JPA 필수 기본 생성자

    public Member(String name, String major, int generation, String part,
                  RoleType roleType, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleType = roleType;
        this.studentId = studentId;
        this.position = position;
    }

    // 공통 필드 수정
    public void updateInfo(String major, int generation, String part) {
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public void updateStudentId(String studentId) { this.studentId = studentId; }
    public void updatePosition(String position) { this.position = position; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public RoleType getRoleType() { return roleType; }
    public String getStudentId() { return studentId; }
    public String getPosition() { return position; }
}