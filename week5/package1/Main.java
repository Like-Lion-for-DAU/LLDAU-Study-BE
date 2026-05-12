package week5.package1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService service = new MemberService();

        System.out.println(" ===== 멋사 멤버 관리 시스템 (Step 1: 레이어 분리) ===== ");

        while (true) {
            System.out.println("\n1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    service.registerMember(scanner);
                    break;
                case "2":
                    service.showAllMembers();
                    break;
                case "3":
                    service.searchByName(scanner);
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("올바른 번호를 입력하세요.");
            }
        }
    }
}
