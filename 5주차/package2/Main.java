package package2;

import java.util.List;
import java.util.Scanner;
import role.Lion;
import role.Role;
import role.Staff;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository");
        System.out.println("2. MockMemberRepository");
        System.out.print("선택: ");

        int repositoryChoice = sc.nextInt();
        sc.nextLine();

        MemberRepository repository;

        if (repositoryChoice == 1) {
            repository = new MemoryMemberRepository();
        } else {
            repository = new MockMemberRepository();
        }

        MemberService service = new MemberService(repository);

        while (true) {
            System.out.println();
            System.out.println("===== 멋사 멤버 관리 시스템 =====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                System.out.println();
                System.out.println("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = sc.nextInt();
                sc.nextLine();

                System.out.println();
                System.out.println("정보 입력");

                System.out.print("이름: ");
                String name = sc.nextLine();

                System.out.print("전공: ");
                String major = sc.nextLine();

                System.out.print("기수: ");
                int generation = sc.nextInt();
                sc.nextLine();

                System.out.print("파트: ");
                String part = sc.nextLine();

                Role member;

                if (roleChoice == 1) {
                    System.out.print("학번: ");
                    String studentId = sc.nextLine();

                    member = new Lion(name, major, generation, part, studentId);
                } else {
                    System.out.print("직책: ");
                    String position = sc.nextLine();

                    member = new Staff(name, major, generation, part, position);
                }

                boolean result = service.register(member);

                if (result) {
                    System.out.println();
                    System.out.println("등록 완료: " + member.getName());
                } else {
                    System.out.println();
                    System.out.println("등록 실패: 이미 존재하는 이름입니다.");
                }

            } else if (menu == 2) {
                System.out.println();
                System.out.println("===== 전체 멤버 조회 =====");

                List<Role> members = service.getAllMembers();

                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.");
                }

                for (Role member : members) {
                    printMember(member);
                    System.out.println();
                }

            } else if (menu == 3) {
                System.out.println();
                System.out.print("검색할 이름: ");
                String name = sc.nextLine();

                Role member = service.searchByName(name);

                System.out.println();
                System.out.println("===== 검색 결과 =====");

                if (member == null) {
                    System.out.println("검색 결과가 없습니다.");
                } else {
                    printMember(member);
                }

            } else if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }

        sc.close();
    }

    public static void printMember(Role member) {
        System.out.println("역할: " + member.getRoleName());
        System.out.println(member.getDetailInfo());
        System.out.println("과제 제출 가능 여부: "
                + (member.canSubmitAssignment() ? "가능" : "불가능"));
    }
}