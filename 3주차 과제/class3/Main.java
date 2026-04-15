package class3;

import class3.role.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====== 🦁 아기사자 정보 입력 ======");
        System.out.print("👤 이름: ");
        String name1 = sc.nextLine();
        System.out.print("🎓 전공: ");
        String major1 = sc.nextLine();
        System.out.print("📌 기수: ");
        int gen1 = sc.nextInt();
        sc.nextLine();
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String part1 = sc.nextLine();
        System.out.print("🆔 학번: ");
        String studentId = sc.nextLine();

        wlq lion = new Lion(name1, major1, gen1, part1, studentId);

        System.out.println("\n====== 👩‍🦲 운영진 정보 입력 ======");
        System.out.print("👤 이름: ");
        String name2 = sc.nextLine();
        System.out.print("🎓 전공: ");
        String major2 = sc.nextLine();
        System.out.print("📌 기수: ");
        int gen2 = sc.nextInt();
        sc.nextLine();
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String part2 = sc.nextLine();
        System.out.print("⭐️ 직책 (대표/부대표/파트장/멘토): ");
        String position = sc.nextLine();

        wlq staff = new Staff(name2, major2, gen2, part2, position);

        System.out.println("\n====== 📋 결과 출력 ======\n");
        print(lion);
        print(staff);

        sc.close();
    }

    public static void print(wlq r) {
        System.out.println(r.getInfo());
        System.out.println("📝 과제 제출 가능 여부: " +
                (r.canSubmit() ? "✅ 가능" : "❌ 불가능"));
        System.out.println("\n -------------------------\n");
    }
}