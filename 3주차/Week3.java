import java.util.*;

public class Week3 {
    abstract class Role {
        String name;
        String major;
        int generation;
        String part;

        public abstract AssignmentPolicy getAssignmentPolicy();

        public boolean canSubmit() {
            return getAssignmentPolicy().canSubmit();
        }

        public abstract void getInfo();
    }

    public class Lion extends Role {
        String number;

        public Lion(String name, String major, int generation, String part, String number) {
            this.name = name;
            this.major = major;
            this.generation = generation;
            this.part = part;
            this.number = number;
        }

        public AssignmentPolicy getAssignmentPolicy() {
            return new BabyLionAssignmentPolicy();
        }

        public void getInfo() {
            System.out.println("이름: " + name + ", 전공: " + major + ", 기수: " + generation + ", 파트: " + part + ", 학번: " + number);
        }
    }

    public class Manager extends Role {
        String position;

        public Manager(String name, String major, int generation, String part, String position) {
            this.name = name;
            this.major = major;
            this.generation = generation;
            this.part = part;
            this.position = position;
        }

        public AssignmentPolicy getAssignmentPolicy() {
            return new ManagerAssignmentPolicy();
        }

        
        public void getInfo() {
            System.out.println("이름: " + name + ", 전공: " + major + ", 기수: " + generation + ", 파트: " + part + ", 직책: " + position);
        }
    }

    public interface AssignmentPolicy {
        boolean canSubmit();
    }

    class BabyLionAssignmentPolicy implements AssignmentPolicy {
        @Override
        public boolean canSubmit() { return true; }
    }

    class ManagerAssignmentPolicy implements AssignmentPolicy {
        @Override
        public boolean canSubmit() { return false; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==== 아기사자 정보 입력 ====");
        System.out.print("이름: "); String lionName = sc.nextLine();
        System.out.print("전공: "); String lionMajor = sc.nextLine();
        System.out.print("기수: "); int lionGen = Integer.parseInt(sc.nextLine()); 
        System.out.print("파트(벡엔드/프론트/디자인/기획 ): "); String lionPart = sc.nextLine();
        System.out.print("학번: "); String lionNumber = sc.nextLine();
        Lion lion = new Week3().new Lion(lionName, lionMajor, lionGen, lionPart, lionNumber);

        System.out.println("==== 운영진 정보 입력 ====");
        System.out.print("이름: "); String managerName = sc.nextLine();
        System.out.print("전공: "); String managerMajor = sc.nextLine();
        System.out.print("기수: "); int managerGen = Integer.parseInt(sc.nextLine());
        System.out.print("파트(벡엔드/프론트/디자인/기획 ): "); String managerPart = sc.nextLine();
        System.out.print("직책(대표/부대표/파트장/멘토): "); String managerPosition = sc.nextLine();
        Manager manager = new Week3().new Manager(managerName, managerMajor, managerGen, managerPart, managerPosition);

        System.out.println("\n==== 아기사자 정보 ====");
        lion.getInfo();
        System.out.println("과제 제출 가능 여부: " + lion.canSubmit());

        System.out.println("\n==== 운영진 정보 ====");
        manager.getInfo();
        System.out.println("과제 제출 가능 여부: " + manager.canSubmit()); 

        sc.close();
    }
}