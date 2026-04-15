package class3;

import class3.role.Lion;
import class3.role.Role;
import class3.role.Staff;
import java.util.Scanner;

/**
 * 프로그램 실행 클래스
 * - 사용자로부터 입력 받아 객체 생성
 * - 역할별 정보 출력
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 아기사자 정보 입력
        System.out.println("===== 🦁 아기사자 정보 입력 =====");
        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        System.out.print("🎓 전공: ");
        String major = sc.nextLine();

        System.out.print("📌 기수: ");
        int gen = sc.nextInt();
        sc.nextLine();

        System.out.print("💻 파트: ");
        String part = sc.nextLine();

        System.out.print("🆔 학번: ");
        String studentId = sc.nextLine();

        Role lion = new Lion(name, major, gen, part, studentId);

        //운영진 정보 입력
        System.out.println("\n===== 🧑‍💼 운영진 정보 입력 =====");
        System.out.print("👤 이름: ");
        String sName = sc.nextLine();

        System.out.print("🎓 전공: ");
        String sMajor = sc.nextLine();

        System.out.print("📌 기수: ");
        int sGen = sc.nextInt();
        sc.nextLine();

        System.out.print("💻 파트: ");
        String sPart = sc.nextLine();

        System.out.print("⭐ 직책: ");
        String position = sc.nextLine();

        Role staff = new Staff(sName, sMajor, sGen, sPart, position);

        //결과 출력
        System.out.println("\n========== 📋 결과 출력 ==========\n");

        printRoleInfo(lion);
        printRoleInfo(staff);
    }

    //역할별 정보 출력 메서드(조건문 없이 동작함)
    public static void printRoleInfo(Role role) {

        System.out.println("🎭 역할: " + role.getRoleName());
        System.out.println(role.getInfo());

        String result = role.canSubmitAssignment() ? "✅ 가능" : "❌ 불가능";
        System.out.println("📝 과제 제출 가능 여부: " + result);

        System.out.println("----------------------------------");
    }
}