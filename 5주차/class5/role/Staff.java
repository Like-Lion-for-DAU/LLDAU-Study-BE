package class5.role;

import class5.policy.StaffSubmitPolicy;
import class5.policy.SubmitPolicy;


public class Staff extends Role {

    private String position;
    //생성자
    public Staff(String name, String position) {
        super(name, "", 0, "");
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
                "\n⭐ 직책: " + position;
    }
}
