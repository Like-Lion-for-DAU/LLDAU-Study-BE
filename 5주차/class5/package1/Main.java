package class5.package1;

import class5.role.Lion;
import class5.role.Role;
import class5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MemberService service = new MemberService();

        while (true) {

            System.out.println();
            System.out.println("🦁 ===== 멋사 멤버 관리 시스템 (Step 1) ===== 🦁");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {

                System.out.println("\n👤 역할 선택 (1: 아기사자, 2: 운영진)");

                int roleNum = sc.nextInt();
                sc.nextLine();

                System.out.println("\n📝 정보 입력");

                System.out.print("이름: ");
                String name = sc.nextLine();

                Role role;

                if (roleNum == 1) {

                    System.out.print("전공: ");
                    String major = sc.nextLine();

                    System.out.print("기수: ");
                    int generation = sc.nextInt();
                    sc.nextLine();

                    System.out.print("파트: ");
                    String part = sc.nextLine();

                    System.out.print("학번: ");
                    String studentId = sc.nextLine();

                    role = new Lion(
                            name,
                            major,
                            generation,
                            part,
                            studentId
                    );

                } else {

                    System.out.print("부서: ");
                    String dept = sc.nextLine();

                    role = new Staff(name, dept);
                }

                boolean result = service.register(role);

                if (result) {
                    System.out.println("\n✅ 등록 완료: " + role.getName());
                } else {
                    System.out.println("\n❌ 중복된 이름입니다.");
                }

            } else if (menu == 2) {

                System.out.println("\n📋 ===== 전체 멤버 조회 =====");

                List<Role> members = service.getAllMembers();

                if (members.isEmpty()) {

                    System.out.println("등록된 멤버가 없습니다.");

                } else {

                    for (Role role : members) {

                        System.out.println("----------------------------");
                        System.out.println(role.getInfo());
                    }
                }

            } else if (menu == 3) {

                System.out.print("\n🔍 검색할 이름: ");
                String name = sc.nextLine();

                Role role = service.searchMember(name);

                System.out.println("\n🎯 ===== 검색 결과 =====");

                if (role == null) {

                    System.out.println("❌ 해당 멤버 없음");

                } else {

                    System.out.println(role.getInfo());
                    System.out.println("📝 과제 제출 가능: ✅ 가능");
                }

            } else if (menu == 4) {

                System.out.println("\n👋 프로그램 종료");
                break;
            }
        }
    }
}