package Iwanna;

public class Lion {
    public String name;
    String major;
    private int number;

    public Lion (String name, String major, int number) {
        this.name = name;
        this.major = major;
        this.number = number;
    }

    public boolean Validation() {

        boolean isValid = true;

        if (name.isEmpty()) {
            System.out.println("❌ 이름은 비어 있을 수 없습니다.");
            isValid = false;

        }

        if (name.isEmpty()) {
            System.out.println("❌ 전공은 비어 있을 수 없습니다.");
            isValid = false;
        }

        if (number < 1) {
            System.out.println("❌ 기수는 1미만일 수 없습니다.");
            isValid = false;
        }

        return isValid;

    }

    public void printInfo() {
        System.out.print("👤 이름 : " + name);
        System.out.print(" | 🎓 전공 : " + major);
        System.out.println(" | 📌 기수 : " + number);
    }


}