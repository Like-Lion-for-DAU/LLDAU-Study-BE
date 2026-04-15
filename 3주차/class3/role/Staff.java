package class3.role;

import class3.policy.StaffSubmitPolicy;
import class3.policy.SubmitPolicy;

/**
 * 운영진 클래스
 * - Role 상속 받아서 운영진의 특징을 구현함
 * - 직책 정보를 추가로 가지고 있음
 */

public class Staff extends Role {

    private String position;
    //생성자
    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }
    //운영진 정책 반환
    @Override
    protected SubmitPolicy getPolicy() {
        return new StaffSubmitPolicy();
    }
    //역할 이름 반환
    @Override
    public String getRoleName() {
        return "운영진";
    }
    //운영진 정보 출력
    @Override
    public String getInfo() {
        return "👤 이름: " + getName() +
                " | 🎓 전공: " + getMajor() +
                " | 📌 기수: " + getGeneration() +
                " | 💻 파트: " + getPart() +
                "\n⭐ 직책: " + position;
    }
}
