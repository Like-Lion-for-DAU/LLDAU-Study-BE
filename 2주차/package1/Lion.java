package package1;

public class Lion {
    public String name;      // public
    String major;            // default
    private int generation;  // private

    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    // Step2용 검증
    public boolean validate() {
        boolean isValid = true;

        if (name == null || name.isEmpty()) {
            System.out.println("❌ 이름이 비어 있습니다.");
            isValid = false;
        }

        if (major == null || major.isEmpty()) {
            System.out.println("❌ 전공이 비어 있습니다.");
            isValid = false;
        }

        if (generation < 1) {
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
            isValid = false;
        }

        return isValid;
    }

    public void printInfo() {
        System.out.println("🧑 이름: " + name + " | 🎓 전공: " + major + " | 📌 기수: " + generation);
    }
}