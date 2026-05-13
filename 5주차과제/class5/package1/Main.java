package class5.package1;

import java.util.Scanner;

import class5.role.Lion;
import class5.role.wlq;
import class5.role.Staff;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MemberService service = new MemberService();

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

                service.register(member);

            } else if (menu == 2) {

                for (wlq member : service.getAllMembers()) {
                    System.out.println(member);
                }

            } else if (menu == 3) {

                System.out.print("검색할 이름: ");
                String name = sc.nextLine();

                wlq member = service.searchByName(name);

                if (member == null) {
                    System.out.println("해당 멤버가 없습니다.");
                } else {
                    System.out.println(member);
                }

            } else if (menu == 0) {

                System.out.println("프로그램 종료");
                break;
            }
        }

        sc.close();
    }
}