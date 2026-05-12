package week5.package2;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 저장소 선택 (구현체 교체)
        System.out.println("저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        String repoChoice = scanner.nextLine().trim();

        // Main에서 Repository 구현체를 생성하고 Service에 주입(Injection)
        MemberRepository repository;
        if (repoChoice.equals("2")) {
            repository = new MockMemberRepository();
        } else {
            repository = new MemoryMemberRepository();
        }

        // Service는 전혀 수정 없이, Main에서 구현체만 바꿔서 동작이 달라짐
        MemberService service = new MemberService(repository);

        System.out.println("\n ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== ");

        while (true) {
            System.out.println("\n1.  멤버 등록");
            System.out.println("2.  전체 멤버 조회");
            System.out.println("3.  이름으로 검색");
            System.out.println("4.  종료");
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
