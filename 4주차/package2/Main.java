package package2;

import java.util.*;
import role.Lion;
import role.Role;
import role.Staff;

public class Main {

    private static List<Role> memberList = new ArrayList<>();
    private static Map<String, Role> memberMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== 🦁 멤버 관리 시스템 (Step2) ====");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addMember();
                case 2 -> viewAll();
                case 3 -> searchName();
                case 4 -> searchByPart();
                case 5 -> {
                    System.out.println("종료");
                    return;
                }
                default -> System.out.println("❗ 잘못된 입력");
            }
        }
    }

    private static void addMember() {
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int role = sc.nextInt();
        sc.nextLine();

        System.out.print("이름: ");
        String name = sc.nextLine();

        if (memberMap.containsKey(name)) {
            System.out.println("❌ 이미 존재하는 이름");
            return;
        }

        System.out.print("전공: ");
        String major = sc.nextLine();

        System.out.print("기수: ");
        int batch = sc.nextInt();
        sc.nextLine();

        System.out.print("파트(백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();

        Role newMember;

        if (role == 1) {
            System.out.print("학번: ");
            String studentId = sc.nextLine();
            newMember = new Lion(name, major, batch, part, studentId);
        } else {
            System.out.print("직책: ");
            String position = sc.nextLine();
            newMember = new Staff(name, major, batch, part, position);
        }

        memberList.add(newMember);
        memberMap.put(name, newMember);

        System.out.println("✅ 등록 완료");
    }

    private static void viewAll() {
        System.out.println("\n📂 전체 멤버 목록");

        for (Role r : memberList) {
            System.out.println(r.getInfo());
            System.out.println("과제 제출 가능: " + (r.canSubmit() ? "✅ 가능" : "❌ 불가"));
            System.out.println();
        }
    }

    private static void searchName() {
        System.out.print("검색할 이름: ");
        String name = sc.nextLine();

        Role r = memberMap.get(name);

        if (r == null) {
            System.out.println("❌ 없음");
        } else {
            System.out.println(r.getInfo());
            System.out.println("제출 가능: " + r.canSubmit());
        }
    }

    private static void searchByPart() {
        System.out.print("조회할 파트(백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();

        System.out.println("\n📁 [" + part + "] 파트 멤버");

        int count = 0;

        for (Role r : memberList) {
            if (r.getInfo().contains(part)) {
                System.out.println(r.getInfo());
                System.out.println("제출 가능: " + r.canSubmit());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("❌ 없음");
        }
    }
}