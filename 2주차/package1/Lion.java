package package1;

public class Lion {
    public String name;
    String major;
    private int generation;

    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    public boolean checkLion() {
        boolean isValid = true;

        if (name.equals("")) {
            System.out.println("이름이 비어 있습니다.");
            isValid = false;
        } else if (major.equals("")) {
            System.out.println("전공이 비어 있습니다.");
            isValid = false;
        }

        if (generation < 1) {
            System.out.println("잘못된 아기사자 정보입니다.");
            isValid = false;
        }

        if (isValid) {
            System.out.println("아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
        }

        return isValid;
    }

    public void printInfo() {
        System.out.println("아기사자 정보를 출력합니다.");
        System.out.println("이름: " + name + " | 전공: " + major + " | 기수: " + generation);
    }
}