package week4.package2;

import week4.policy.LionSubmissionPolicy;
import week4.policy.StaffSubmissionPolicy;
import week4.policy.SubmissionPolicy;
import week4.role.Lion;
import week4.role.Role;
import week4.role.Staff;

import java.util.*;

public class Main {

    private static final List<Role> memberList = new ArrayList<>();

    private static final Map<String, List<Role>> partMap = new LinkedHashMap<>();

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("선택: ");
            String input = sc.nextLine().trim();

            if (input.equals("1")) {
                registerMember();
            } else if (input.equals("2")) {
                listAllMembers();
            } else if (input.equals("3")) {
                searchByName();
            } else if (input.equals("4")) {
                listByPart();
            } else if (input.equals("5")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else {
                System.out.println("올바른 번호를 입력하세요.\n");
            }
        }
    }

    //메뉴 출력
    private static void printMenu() {
        System.out.println("======== 멤버 관리 시스템 ========");
        System.out.println("1. 멤버 등록");
        System.out.println("2. 전체 멤버 조회");
        System.out.println("3. 이름으로 검색");
        System.out.println("4. 파트별 조회");
        System.out.println("5. 종료");
    }

    // 멤버 등록
    private static void registerMember() {
        System.out.println("\n— 멤버 등록 —");
        String roleInput;
        while (true) {
            System.out.print("역할 선택 (1: 아기사자, 2: 운영진) 번호를 입력해 주세요: ");
            roleInput = sc.nextLine().trim();
            if (roleInput.equals("1") || roleInput.equals("2")) {
                break;
            }
            System.out.println("올바른 역할을 선택하세요. (1 또는 2 입력)");
        }

        System.out.print("이름: ");
        String name = sc.nextLine().trim();

        // 중복 이름 확인
        for (Role r : memberList) {
            if (r.getName().equals(name)) {
                System.out.println("등록 실패: 이미 존재하는 이름입니다.\n");
                return;
            }
        }

        System.out.print("전공: ");
        String major = sc.nextLine().trim();

        int generation;
        while (true) {
            System.out.print("기수(숫자만 입력하세요): ");
            try {
                generation = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("기수는 숫자로만 입력해야 합니다. 다시 입력해 주세요.");
            }
        }

        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine().trim();

        System.out.print("학번: ");
        String studentId = sc.nextLine().trim();

        Role newMember;
        if (roleInput.equals("1")) {
            newMember = new Lion(name, major, generation, part, studentId);
        } else {
            newMember = new Staff(name, major, generation, part, studentId);
        }


        memberList.add(newMember);

        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(newMember);

        System.out.println("등록 완료: " + name + "\n");
    }

    //  전체 멤버 조회
    private static void listAllMembers() {
        System.out.println("\n— 전체 멤버 목록 —");
        if (memberList.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.\n");
            return;
        }
        for (int i = 0; i < memberList.size(); i++) {
            Role r = memberList.get(i);
            System.out.printf("%d. [%s] %s - %d기%n",
                    i + 1, r.getRoleLabel(), r.getName(), r.getGeneration());
        }
        System.out.printf("총 %d명%n%n", memberList.size());
    }

    // 이름으로 검색
    private static void searchByName() {
        System.out.println("\n— 이름으로 검색 —");
        System.out.print("검색할 이름: ");
        String name = sc.nextLine().trim();

        for (Role r : memberList) {
            if (r.getName().equals(name)) {
                SubmissionPolicy policy = (r instanceof Lion)
                        ? new LionSubmissionPolicy()
                        : new StaffSubmissionPolicy();

                System.out.println("\n[검색 결과]");
                System.out.printf("역할: %s%n", r.getRoleLabel());
                System.out.printf("이름: %s | 전공: %s | 기수: %d | 파트: %s%n",
                        r.getName(), r.getMajor(), r.getGeneration(), r.getPart());
                System.out.printf("\t학번: %s%n", r.getStudentId());
                System.out.printf("과제 제출 가능 여부: %s %s%n%n",
                        policy.canSubmit() ? "✅" : "❌",
                        policy.description());
                return;
            }
        }
        System.out.println("해당 이름의 멤버를 찾을 수 없습니다.\n");
    }

    //  파트별 조회
    private static void listByPart() {
        System.out.println("\n— 💻 파트별 조회 —");
        if (partMap.isEmpty()) {
            System.out.println("등록된 파트가 없습니다.\n");
            return;
        }

        // 등록된 파트 목록 출력
        System.out.println(" 등록된 파트: " + partMap.keySet());
        System.out.print("조회할 파트: ");
        String part = sc.nextLine().trim();

        List<Role> partMembers = partMap.get(part);
        if (partMembers == null || partMembers.isEmpty()) {
            System.out.println("해당 파트의 멤버가 없습니다.\n");
            return;
        }

        System.out.printf("%n [%s 파트 멤버]%n", part);
        for (int i = 0; i < partMembers.size(); i++) {
            Role r = partMembers.get(i);
            System.out.printf("%d. %s (%s) - %d기%n",
                    i + 1, r.getName(), r.getRoleLabel(), r.getGeneration());
        }
        System.out.println();
    }
}