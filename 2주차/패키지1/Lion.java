package 패키지1;

public class Lion {
    public String name;     // public
    String major;           // default
    private int generation; // private

    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("전공: " + major);
        System.out.println("기수: " + generation);
    }

    public boolean validate() {
    if (name == null || name.isEmpty()) {
        System.out.println("❌ 이름이 유효하지 않습니다.");
        return false;
    }
    if (major == null || major.isEmpty()) {
        System.out.println("❌ 전공이 유효하지 않습니다.");
        return false;
    }
    if (generation < 1) {
        System.out.println("❌ 기수는 1 이상이어야 합니다.");
        return false;
    }
    return true;
    }
}