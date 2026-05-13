package package2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("저장소를 선택하세요.");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository(더미 데이터)");
        System.out.print("선택: ");

        int repoChoice = sc.nextInt();
        sc.nextLine();

        MemberRepository repository;

        if (repoChoice == 1) {
            repository = new MemoryMemberRepository();
        } else {
            repository = new MockMemberRepository();
        }

        MemberService service = new MemberService(repository);

        while (true) {
            System.out.println("\n===== 멋사 멤버 관리 시스템 (Step 2 : DI 적용) =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    service.registerMember(sc);
                    break;

                case 2:
                    service.showAllMembers();
                    break;

                case 3:
                    System.out.print("검색할 이름: ");
                    String name = sc.nextLine();
                    service.searchMember(name);
                    break;

                case 4:
                    System.out.println("프로그램 종료");
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}