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

    public boolean checkSelfStatus() {
        boolean valid = true;
        if (name == null || name.isEmpty()) {
            System.out.println("이름이 비어 있습니다.");
            valid = false;
        }
        if (major == null || major.isEmpty()) {
            System.out.println("전공이 비어 있습니다.");
            valid = false;
        }
        if (generation < 1) {
            System.out.println("기수가 1 미만입니다."); 
            valid = false;
        }
        
        if (!valid) {
            System.out.println("잘못된 아기사자 정보입니다.");
        }
        return valid;
    }

    public void printInfo() {
        System.out.println("아기사자 정보를 출력합니다.");
        System.out.printf("이름: %s | 전공: %s | 기수: %d\n", name, major, generation);
    }
}