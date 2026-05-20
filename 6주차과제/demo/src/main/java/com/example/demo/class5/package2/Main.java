package com.example.demo.class5.package2;

import java.util.Scanner;

import com.example.demo.class5.role.Lion;
import com.example.demo.class5.role.Staff;
import com.example.demo.class5.role.wlq;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");

        int repoChoice = sc.nextInt();
        sc.nextLine();

        MemberRepository repository;

        if (repoChoice == 1) {
            repository = new MemoryMemberRepository();
        } else {
            repository = new MockMemberRepository();
        }

        MemberService service = new MemberService(repository);

        while (true) {

            System.out.println("1. 등록 2. 전체조회 3. 이름검색 4. 종료");
            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {

                System.out.print("역할선택 (1: 아기사자 / 2: 운영진): ");
                int role = sc.nextInt();
                sc.nextLine();
                
                System.out.print("이름: ");
                String name = sc.nextLine();

                System.out.print("전공: ");
                String major = sc.nextLine();

                System.out.print("기수: ");
                int generation = sc.nextInt();
                sc.nextLine();

                System.out.print("파트: ");
                String part = sc.nextLine();

                System.out.print("학번: ");
                String studentId = sc.nextLine();

                wlq member;

                if (role == 1) {
                    member = new Lion(name, major, generation, part, studentId);
                } else {
                    member = new Staff(name, major, generation, part, studentId);
                }

                boolean result = service.register(member);

                if (result) {
                    System.out.println("등록 완료");
                } else {
                    System.out.println("이미 존재하는 이름입니다.");
                }

            }

            else if (menu == 2) {

                for (wlq member : service.getAllMembers()) {
                    System.out.println(member);
                }

            }

            else if (menu == 3) {

                System.out.print("검색할 이름: ");
                String name = sc.nextLine();

                wlq member = service.searchByName(name);

                if (member == null) {
                    System.out.println("해당 멤버가 없습니다.");
                } else {
                    System.out.println(member);
                }

            }

            else if (menu == 0) {

                System.out.println("프로그램 종료");
                break;

            }

            else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
    }
}