package class4.package1;

import class4.role.*;
import java.util.*;

public class Main {

    static List<Role> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\\n======== 🦁 멤버 관리 시스템 ========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 -> register();
                case 2 -> printAll();
                case 3 -> searchByName();
                case 4 -> {
                    System.out.println("프로그램 종료");
                    return;
                }
            }
        }
    }

    // ✅ 등록
    static void register() {
        System.out.println("\n———📝 멤버 등록———");

        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        // 🔥 중복 검사
        for (Role r : members) {
            if (r.getName().equals(name)) {
                System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                return;
            }
        }

        System.out.print("🎓 전공: ");
        String major = sc.nextLine();

        System.out.print("📌 기수: ");
        int generation = sc.nextInt();
        sc.nextLine();

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();

        Role newMember;

        if (type == 1) {
            System.out.print("🆔 학번: ");
            String studentId = sc.nextLine();

            // 👉 3주차 생성자 그대로 사용
            newMember = new Lion(name, major, generation, part, studentId);

        } else {
            newMember = new Staff(name, major, generation, part);
        }

        members.add(newMember);

        System.out.println("✅ 등록 완료: " + name);
    }

    // ✅ 전체 조회
    static void printAll() {
        System.out.println("\n———📋 전체 멤버 목록———");

        if (members.isEmpty()) {
            System.out.println("등록된 멤버 없음");
            return;
        }

        int idx = 1;
        for (Role r : members) {

            String roleName = (r instanceof Lion) ? "아기사자" : "운영진";

            System.out.println(
                    idx++ + ". [" + roleName + "] "
                            + r.getName() + " - "
                            + r.getGeneration() + "기"
            );
        }

        System.out.println("\n📊 총 " + members.size() + "명");
    }

    // ✅ 이름 검색
    static void searchByName() {
        System.out.println("\n🔍 이름으로 검색");

        System.out.print("검색할 이름: ");
        String name = sc.nextLine();

        for (Role r : members) {
            if (r.getName().equals(name)) {

                String roleName = (r instanceof Lion) ? "아기사자" : "운영진";

                System.out.println("\n✨ [검색 결과]");
                System.out.println("🎭 역할: " + roleName);

                System.out.println(
                        "이름: " + r.getName()
                                + " |  전공: " + r.getMajor()
                                + " |  기수: " + r.getGeneration()
                                + " |  파트: " + r.getPart()
                );

                // 🔥 Lion일 때만 학번 + 제출 여부
                if (r instanceof Lion) {
                    Lion lion = (Lion) r;

                    System.out.println("학번: " + lion.getStudentId());

                    // 👉 policy 연결되어 있을 경우
                    try {
                        boolean canSubmit = lion.canSubmitAssignment();
                        System.out.println("📄 과제 제출 가능 여부: "
                                + (canSubmit ? "✅ 가능" : "❌ 불가능"));
                    } catch (Exception e) {
                        // 정책 없으면 무시
                    }
                }

                return;
            }
        }

        System.out.println("❌ 검색 결과 없음");
    }
}