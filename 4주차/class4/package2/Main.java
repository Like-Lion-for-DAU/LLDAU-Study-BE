package class4.package2;

import class4.role.Role;
import class4.role.Lion;
import class4.role.Staff;
import java.util.*;

public class Main {
    private static List<Role> memberList = new ArrayList<>();
    private static Map<String, List<Role>> partMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= 멤버 관리 시스템 (Step 2) =========");
            System.out.println("1. 등록 / 2. 전체조회 / 3. 이름검색 / 4. 파트별조회 / 5. 종료");
            System.out.print("선택: ");
            String menu = scanner.nextLine();

            if (menu.equals("1")) register();
            else if (menu.equals("2")) showAll();
            else if (menu.equals("3")) search();
            else if (menu.equals("4")) showByPart();
            else if (menu.equals("5")) break;
        }
    }

    private static void register() {
        System.out.print("역할 (1: 아기사자, 2: 운영진): ");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("전공: "); String major = scanner.nextLine();
        System.out.print("기수: "); int ord = Integer.parseInt(scanner.nextLine());
        System.out.print("파트: "); String part = scanner.nextLine();

        Role member;
        if (type == 1) {
            System.out.print("학번: "); String id = scanner.nextLine();
            member = new Lion(name, major, ord, part, id);
        } else {
            System.out.print("직책: "); String pos = scanner.nextLine();
            member = new Staff(name, major, ord, part, pos);
        }

        memberList.add(member);
        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(member);
        System.out.println("등록 및 파트 분류 완료!");
    }

    private static void showByPart() {
        System.out.println("현재 파트: " + partMap.keySet());
        System.out.print("조회할 파트: ");
        String target = scanner.nextLine();

        if (!partMap.containsKey(target)) {
            System.out.println("해당 파트가 존재하지 않습니다.");
            return;
        }

        for (Role r : partMap.get(target)) {
            System.out.println("- " + r.getName());
        }
    }

    private static void showAll() {
        if (memberList.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return;
        }
        for (Role r : memberList) System.out.println(r.toString());
    }

    private static void search() {
        System.out.print("이름 검색: ");
        String name = scanner.nextLine();
        for (Role r : memberList) {
            if (r.getName().equals(name)) {
                System.out.println(r.toString());
                return;
            }
        }
        System.out.println("검색 결과가 없습니다.");
    }
}