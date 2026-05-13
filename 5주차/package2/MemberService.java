package package2;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.Scanner;

public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void registerMember(Scanner sc) {
        System.out.println("1. 아기사자");
        System.out.println("2. 운영진");
        System.out.print("역할 선택: ");

        int roleNum = sc.nextInt();
        sc.nextLine();

        System.out.print("이름: ");
        String name = sc.nextLine();

    if (repository.existsByName(name)) {
        System.out.println("이미 존재하는 이름입니다.");
        return;
    }

        System.out.print("전공: ");
        String major = sc.nextLine();

        System.out.print("기수: ");
        int batch = sc.nextInt();
        sc.nextLine();

        System.out.print("파트(백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();

        Role role;

        if (roleNum == 1) {
            System.out.print("학번: ");
            String studentId = sc.nextLine();

            role = new Lion(name, major, batch, part, studentId);
        } else {
            System.out.print("직책(대표/부대표/파트장/멘토): ");
            String position = sc.nextLine();

            role = new Staff(name, major, batch, part, position);
        }

        repository.save(role);
        System.out.println("등록 완료!");
    }

    public void showAllMembers() {
        for (Role role : repository.findAll()) {
            System.out.println("----------------------");
            System.out.println(role.getInfo());
            System.out.println("과제 제출 가능 여부: " + role.canSubmit());
        }
    }

    public void searchMember(String name) {
        Role role = repository.findByName(name);

        if (role == null) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println(role.getInfo());
            System.out.println("과제 제출 가능 여부: " + role.canSubmit());
        }
    }
}