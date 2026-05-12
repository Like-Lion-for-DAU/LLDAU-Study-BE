package role;

import policy.submit;

abstract public class Role{
    public int j;
    public String name;
    public String major;
    public int num;
    public String part;

    public Role(int j, String name, String major, int num, String part){
        this.j = j;
        this.name = name;
        this.major = major;
        this.num = num;
        this.part = part;
    }
    public abstract submit getPol();

    public void canSubmit() {
        submit obj = getPol();

        if (obj.isSubmit()) {
            System.out.println("과제 제출 가능 여부 : 가능!");
        } else {
            System.out.println("과제 제출 가능 여부 : 불가능!");
        }
    }

    public abstract String getInfo();

}