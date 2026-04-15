import java.util.Scanner;
import role.Lion;
import role.Role;
import role.Staff;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== 아기사자 입력 =====
        System.out.println("🦁 아기사자 정보 입력");
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("전공: ");
        String major = sc.nextLine();
        System.out.print("기수: ");
        int batch = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();
        System.out.print("학번: ");
        String studentId = sc.nextLine();

        Role lion = new Lion(name, major, batch, part, studentId);

        // ===== 운영진 입력 =====
        System.out.println("\n🧑‍💼 운영진 정보 입력");
        System.out.print("이름: ");
        String sName = sc.nextLine();
        System.out.print("전공: ");
        String sMajor = sc.nextLine();
        System.out.print("기수: ");
        int sBatch = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String sPart = sc.nextLine();
        System.out.print("직책: ");
        String position = sc.nextLine();

        Role staff = new Staff(sName, sMajor, sBatch, sPart, position);

        // ===== 출력 =====
        System.out.println("\n===== 아기사자 정보 출력 =====\n");

        printResult(lion);
        System.out.println();
        printResult(staff);
    }

    private static void printResult(Role role) {
        System.out.println(role.getInfo());
        System.out.println("과제 제출 가능 여부: " +
                (role.canSubmit() ? "✅ 가능" : "❌ 불가능"));
    }
}