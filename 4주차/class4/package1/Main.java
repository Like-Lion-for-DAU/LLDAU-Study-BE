package class4.package1;

import class4.role.Role;
import class4.role.Lion;
import class4.role.Staff;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Role> memberList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= 멤버 관리 시스템 (Step 1) =========");
            System.out.println("1. 멤버 등록 / 2. 전체 조회 / 3. 이름 검색 / 4. 종료");
            System.out.print("선택: ");
            String menu = scanner.nextLine();

            if (menu.equals("1")) register();
            else if (menu.equals("2")) showAll();
            else if (menu.equals("3")) search();
            else if (menu.equals("4")) break;
        }
    }

    private static void register() {
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.print("이름: ");
        String name = scanner.nextLine();

        for (Role r : memberList) {
            if (r.getName().equals(name)) {
                System.out.println("중복된 이름입니다.");
                return;
            }
        }

        System.out.print("전공: "); String major = scanner.nextLine();
        System.out.print("기수: "); int ord = Integer.parseInt(scanner.nextLine());
        System.out.print("파트: "); String part = scanner.nextLine();

        if (type == 1) {
            System.out.print("학번: "); String id = scanner.nextLine();
            memberList.add(new Lion(name, major, ord, part, id));
        } else {
            System.out.print("직책: "); String pos = scanner.nextLine();
            memberList.add(new Staff(name, major, ord, part, pos));
        }
        System.out.println("등록 완료!");
    }

    private static void showAll() {
        if (memberList.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        for (Role r : memberList) {
            System.out.println(r.getName() + " (" + r.getPart() + ")");
        }
    }

    private static void search() {
        System.out.print("검색할 이름: ");
        String name = scanner.nextLine();
        for (Role r : memberList) {
            if (r.getName().equals(name)) {
                System.out.println("결과: " + r.toString());
                return;
            }
        }
        System.out.println("검색 결과가 없습니다.");
    }
}