package class5.package2;

import class5.Member;
import class5.role.*;
import class5.policy.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("저장소를 선택하세요 (1: 실제저장소, 2: 가짜저장소):");
        int repoType = sc.nextInt();
        
        MemberRepository repository = (repoType == 1) ? new MemoryMemberRepository() : new MockMemberRepository();
        MemberService service = new MemberService(repository);

        while (true) {
            System.out.println("\n멋사 멤버 관리 시스템");
            System.out.println("1. 멤버 등록 | 2. 전체 조회 | 3. 이름 검색 | 4. 종료");
            int menu = sc.nextInt();
            if (menu == 4) break;

            switch (menu) {
                case 1 -> {
                    System.out.print("역할 (1: 아기사자, 2: 운영진): "); int r = sc.nextInt();
                    System.out.print("이름: "); String name = sc.next();
                    System.out.print("전공: "); String major = sc.next();
                    System.out.print("기수: "); int term = sc.nextInt();
                    System.out.print("파트 (PM/프론트/백엔드): "); String part = sc.next();
                    System.out.print("학번: "); String id = sc.next();

                    Role role = (r == 1) ? new Lion() : new Staff();
                    AssignmentPolicy policy = (r == 1) ? new LionAssignmentPolicy() : new StaffAssignmentPolicy();
                    service.register(new Member(name, major, term, part, id, role, policy));
                }
                case 2 -> service.findAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("검색할 이름: "); String n = sc.next();
                    Member m = service.findByName(n);
                    System.out.println(m != null ? m : "결과 없음");
                }
            }
        }
    }
}