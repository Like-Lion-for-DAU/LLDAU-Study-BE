package package2;

import role.*;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Role> members = new ArrayList<>();
    private static final Map<String, List<Role>> partMembers = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int menu = readInt("메뉴 선택: ");

            if (menu == 1) {
                registerMember();
            } else if (menu == 2) {
                printAllMembers();
            } else if (menu == 3) {
                searchMemberByName();
            } else if (menu == 4) {
                printPartMembers();
            } else if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else {
                System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("==== Step 2 파트별 멤버 관리 ====");
        System.out.println("1. 멤버 등록");
        System.out.println("2. 전체 멤버 조회");
        System.out.println("3. 이름으로 멤버 검색");
        System.out.println("4. 파트별 멤버 조회");
        System.out.println("0. 종료");
    }

    private static void registerMember() {
        String name = readString("이름: ");

        if (findMemberByName(name) != null) {
            System.out.println("이미 등록된 이름입니다. 등록에 실패했습니다.");
            return;
        }

        String major = readString("전공: ");
        int generation = readInt("기수: ");
        String part = readString("파트(백엔드/프론트/디자인/기획): ");
        int role = readInt("역할 선택(1. 아기사자, 2. 운영진): ");
        Role member;

        if (role == 1) {
            String number = readString("학번: ");
            member = new Lion(name, major, generation, part, number);
        } else if (role == 2) {
            String position = readString("직책(대표/부대표/파트장/멘토): ");
            member = new Staff(name, major, generation, part, position);
        } else {
            System.out.println("역할 선택이 올바르지 않아 등록에 실패했습니다.");
            return;
        }

        members.add(member);

        if (!partMembers.containsKey(part)) {
            partMembers.put(part, new ArrayList<>());
        }

        partMembers.get(part).add(member);
        System.out.println("멤버 등록이 완료되었습니다.");
    }

    private static void printAllMembers() {
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        for (Role member : members) {
            member.getInfo();
            System.out.println("과제 제출 가능 여부: " + member.canSubmit());
        }
    }

    private static void searchMemberByName() {
        String name = readString("검색할 이름: ");
        Role member = findMemberByName(name);

        if (member == null) {
            System.out.println("해당 이름을 가진 멤버가 없습니다.");
            return;
        }

        member.getInfo();
        System.out.println("과제 제출 가능 여부: " + member.canSubmit());
    }

    private static void printPartMembers() {
        if (partMembers.isEmpty()) {
            System.out.println("등록된 파트가 없습니다.");
            return;
        }

        System.out.println("등록된 파트 목록");
        for (String savedPart : partMembers.keySet()) {
            System.out.println("- " + savedPart);
        }

        String part = readString("조회할 파트명: ");

        if (!partMembers.containsKey(part)) {
            System.out.println("해당 파트에 등록된 멤버가 없습니다.");
            return;
        }

        for (Role member : partMembers.get(part)) {
            member.getInfo();
            System.out.println("과제 제출 가능 여부: " + member.canSubmit());
        }
    }

    private static Role findMemberByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    private static String readString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
