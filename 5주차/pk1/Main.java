package pk1;

import role.Lion;
import role.Role;
import role.Staff;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static MemberService memberService = new MemberService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n======== 멤버 시스템 관리 =======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            int n = sc.nextInt();
            sc.nextLine();

            if (n == 4) break;
            if (n == 1) registerMember();
            else if (n == 2) showAll();
            else if (n == 3) searchByName();
        }
    }

    private static void registerMember() {
        System.out.print("역할 선택(1: 아기사자, 2: 운영진) : ");
        int j = sc.nextInt();
        sc.nextLine();

        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전공 : ");
        String major = sc.nextLine();
        System.out.print("기수 : ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 : ");
        String part = sc.nextLine();

        Role role;
        if (j == 1) {
            System.out.print("학번 : ");
            int index = sc.nextInt();
            sc.nextLine();
            role = new Lion(1, name, major, num, part, index);
        } else {
            System.out.print("직책 : ");
            String pos = sc.nextLine();
            role = new Staff(2, name, major, num, part, pos);
        }

        if (memberService.check(role)) {
            System.out.println("등록 성공!");
        } else {
            System.out.println("등록 실패 : 이미 존재하는 이름입니다.");
        }
    }

    private static void showAll() {
        System.out.println("-- 전체 멤버 목록 --");
        var list = memberService.findMembers();
        for (int i = 0; i < list.size(); i++) {
            Role r = list.get(i);
            String roleStr = (r.j == 1) ? "아기사자" : "운영진";
            System.out.println((i + 1) + ". [" + roleStr + "] " + r.name + " - " + r.num + "기");
        }
        System.out.println("총 " + list.size() + "명");
    }

    private static void searchByName() {
        System.out.print("검색할 이름 : ");
        String name = sc.nextLine();
        Role r = memberService.findOne(name);
        if (r != null) {
            String roleStr = (r.j == 1) ? "아기사자" : "운영진";
            System.out.println("역할 : " + roleStr);
            System.out.println(r.getInfo());
            r.canSubmit();
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }
}


