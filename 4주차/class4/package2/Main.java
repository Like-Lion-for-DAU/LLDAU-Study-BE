package class4.package2;

import class4.role.*;
import java.util.*;

public class Main {

    static List<Role> members = new ArrayList<>();
    static Map<String, List<Role>> partMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n======== 🦁 멤버 관리 시스템 ========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 -> register();
                case 2 -> printAll();
                case 3 -> searchByName();
                case 4 -> searchByPart();
                case 5 -> {
                    System.out.println("👋 프로그램 종료");
                    return;
                }
            }
        }
    }

    static void register() {
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        // 중복 체크
        for (Role r : members) {
            if (r.getName().equals(name)) {
                System.out.println("중복 이름");
                return;
            }
        }

        System.out.print("🎓 전공: ");
        String major = sc.nextLine();

        System.out.print("📌 기수: ");
        int generation = sc.nextInt();
        sc.nextLine();

        System.out.print("💻파트: ");
        String part = sc.nextLine();

        Role newMember;

        if (type == 1) {
            System.out.print("🆔학번: ");
            String studentId = sc.nextLine();
            newMember = new Lion(name, major, generation, part, studentId);
        } else {
            newMember = new Staff(name, major, generation, part);
        }

        members.add(newMember);

        // 🔥 Map 추가 핵심
        partMap.putIfAbsent(part, new ArrayList<>());
        partMap.get(part).add(newMember);

        System.out.println("✅ 등록 완료: " + name);
    }

    static void printAll() {
        for (Role r : members) {
            System.out.println(r.getInfo());
        }
    }

    static void searchByName() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        for (Role r : members) {
            if (r.getName().equals(name)) {
                System.out.println(r.getInfo());
                return;
            }
        }
        System.out.println("없음");
    }

    static void searchByPart() {
        System.out.println("\n———💻 파트별 조회 ———");
        System.out.println("📁등록된 파트: " + new ArrayList<>(partMap.keySet()));

        System.out.print("조회할 파트: ");
        String part = sc.nextLine();

        if (!partMap.containsKey(part)) {
            System.out.println("해당 파트 없음");
            return;
        }

        System.out.println("\n✨ [" + part + " 파트 멤버]");
        int idx = 1;
        for (Role r : partMap.get(part)) {
            System.out.println(idx++ + ". " + r.getName() + " (" + r.getRoleName() + ") - " + r.getGeneration() + "기");
        }
    }
}