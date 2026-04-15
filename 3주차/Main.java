import java.util.Scanner;
import role.Person;
import role.Lion;
import role.Staff;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======== 아기사자 정보 입력 ========");
        System.out.print("이름: ");
        String lionName = sc.nextLine();

        System.out.print("전공: ");
        String lionMajor = sc.nextLine();

        System.out.print("기수: ");
        int lionGeneration = sc.nextInt();
        sc.nextLine();

        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionPart = sc.nextLine();

        System.out.print("학번: ");
        String lionStudentId = sc.nextLine();

        System.out.println();

        System.out.println("======== 운영진 정보 입력 ========");
        System.out.print("이름: ");
        String staffName = sc.nextLine();

        System.out.print("전공: ");
        String staffMajor = sc.nextLine();

        System.out.print("기수: ");
        int staffGeneration = sc.nextInt();
        sc.nextLine();

        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffPart = sc.nextLine();

        System.out.print("직책 (대표/부대표/파트장/멘토): ");
        String staffPosition = sc.nextLine();

        System.out.println();

        Person lion = new Lion(lionName, lionMajor, lionGeneration, lionPart, lionStudentId);
        Person staff = new Staff(staffName, staffMajor, staffGeneration, staffPart, staffPosition);

        System.out.println("======== 결과 출력 ========");
        System.out.println();

        System.out.println("역할: " + lion.getRoleName());
        System.out.println(lion.getDetailInfo());
        System.out.println("과제 제출 가능 여부: " + (lion.canSubmitAssignment() ? "가능" : "불가능"));
        System.out.println("----------------------------");
        System.out.println();

        System.out.println("역할: " + staff.getRoleName());
        System.out.println(staff.getDetailInfo());
        System.out.println("과제 제출 가능 여부: " + (staff.canSubmitAssignment() ? "가능" : "불가능"));

        sc.close();
    }
}