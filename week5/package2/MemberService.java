package week5.package2;

import week5.role.Lion;
import week5.role.Role;
import week5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    // Step 2: 생성자를 통해 주입받음, 인터페이스(데이터를 저장하고 찾는 기능 그 자체)에만 의존 (느슨한 결합)
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void registerMember(Scanner scanner) {
        System.out.print(" 역할 선택 (1: 아기사자, 2: 운영진): ");
        int roleChoice = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("\n 정보 입력");
        System.out.print("이름: ");
        String name = scanner.nextLine().trim();

        if (repository.existsByName(name)) {
            System.out.println("등록 실패: 이미 존재하는 이름입니다. (" + name + ")");
            return;
        }

        System.out.print("전공: ");
        String major = scanner.nextLine().trim();
        System.out.print("기수: ");
        int generation = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("파트: ");
        String part = scanner.nextLine().trim();
        System.out.print("학번: ");
        String studentId = scanner.nextLine().trim();

        Role member;
        if (roleChoice == 1) {
            member = new Lion(name, major, generation, part, studentId);
        } else {
            member = new Staff(name, major, generation, part, studentId);
        }

        repository.save(member);
        System.out.println("등록 완료: " + name);
    }

    public void showAllMembers() {
        List<Role> members = repository.findAll();
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        System.out.println("🐾 ===== 전체 멤버 목록 =====");
        for (Role member : members) {
            System.out.println(member);
            System.out.println("----------------------------");
        }
    }

    public void searchByName(Scanner scanner) {
        System.out.print(" 검색할 이름: ");
        String name = scanner.nextLine().trim();

        Role member = repository.findByName(name);
        if (member == null) {
            System.out.println("해당 이름의 멤버를 찾을 수 없습니다: " + name);
        } else {
            System.out.println(" ===== 검색 결과 =====");
            System.out.println(member);
        }
    }
}
