package Class5.package2;

import Class5.role.Lion;
import Class5.role.Role;
import Class5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static MemberService memberService;

    public static void main(String[] args) {
        MemberRepository repository = selectRepository();
        memberService = new MemberService(repository);

        while (true) {
            printMenu();
            int menu = inputInt("선택: ");

            if (menu == 1) {
                registerMember();
            } else if (menu == 2) {
                printAllMembers();
            } else if (menu == 3) {
                searchMemberByName();
            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }
    }

    private static MemberRepository selectRepository() {
        System.out.println("저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");

        while (true) {
            int repositoryNumber = inputInt("선택: ");

            if (repositoryNumber == 1) {
                return new MemoryMemberRepository();
            }

            if (repositoryNumber == 2) {
                return new MockMemberRepository();
            }

            System.out.println("잘못된 저장소입니다.");
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) =====");
        System.out.println("1. 멤버 등록");
        System.out.println("2. 전체 멤버 조회");
        System.out.println("3. 이름으로 검색");
        System.out.println("4. 종료");
    }

    private static void registerMember() {
        System.out.println();
        System.out.println("역할 선택 (1: 아기사자, 2: 운영진): ");
        int roleNumber = inputInt("");

        System.out.println();
        System.out.println("정보 입력");
        String name = inputText("이름: ");
        String major = inputText("전공: ");
        int generation = inputInt("기수: ");
        String part = inputText("파트: ");

        Role member;
        if (roleNumber == 1) {
            String studentNumber = inputText("학번: ");
            member = new Lion(name, major, generation, part, studentNumber);
        } else if (roleNumber == 2) {
            String position = inputText("직책: ");
            member = new Staff(name, major, generation, part, position);
        } else {
            System.out.println("잘못된 역할입니다.");
            return;
        }

        boolean result = memberService.register(member);
        if (result) {
            System.out.println("등록 완료: " + member.getName());
        } else {
            System.out.println("이미 등록된 이름입니다: " + member.getName());
        }
    }

    private static void printAllMembers() {
        List<Role> members = memberService.findAllMembers();

        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("===== 전체 멤버 목록 =====");
        for (Role member : members) {
            printMember(member);
        }
    }

    private static void searchMemberByName() {
        String name = inputText("검색할 이름: ");
        Role member = memberService.findMemberByName(name);

        if (member == null) {
            System.out.println("해당 이름의 멤버를 찾을 수 없습니다: " + name);
            return;
        }

        System.out.println();
        System.out.println("===== 검색 결과 =====");
        printMember(member);
    }

    private static void printMember(Role member) {
        member.getInfo();
        System.out.println("과제 제출 가능: " + (member.canSubmit() ? "가능" : "불가능"));
    }

    private static String inputText(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static int inputInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
