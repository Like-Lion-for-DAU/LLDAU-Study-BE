package week3;

import week3.member.Lion;
import week3.member.Member;
import week3.member.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 아기사자 입력
        System.out.println("======= 🦁 아기사자 정보 입력 =======");
        System.out.print("👤 이름: "); String lName = scanner.next();
        System.out.print("🎓 전공: "); String lMajor = scanner.next();
        System.out.print("📌 기수: "); int lYear = scanner.nextInt();
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): "); String lPart = scanner.next();
        System.out.print("🆔 학번: "); String lId = scanner.next();

        Member lion = new Lion(lName, lMajor, lYear, lPart, lId);

        // 운영진 정보 입력 화면
        System.out.println("\n======= 👤 운영진 정보 입력 =======");
        System.out.print("👤 이름: "); String sName = scanner.next();
        System.out.print("🎓 전공: "); String sMajor = scanner.next();
        System.out.print("📌 기수: "); int sYear = scanner.nextInt();
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): "); String sPart = scanner.next();
        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): "); String sPos = scanner.next();

        Member staff = new Staff(sName, sMajor, sYear, sPart, sPos);

        // 결과 출력 화면
        System.out.println("\n========= 📋 결과 출력 =========");
        printFinalResult(lion);
        System.out.println();
        printFinalResult(staff);
        System.out.println("==============================");

        scanner.close();
    }

    private static void printFinalResult(Member member) {
        System.out.println(member.getDetails());

        boolean canSubmit = member.canSubmitAssignment();
        String icon = canSubmit ? "✅" : "❌";
        String status = canSubmit ? "가능" : "불가능";

        System.out.println("📝 과제 제출 가능 여부: " + icon + " " + status);
        System.out.println("------------------------------");
    }
}
