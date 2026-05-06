package package1;

import java.util.*;
import class4.role.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<wlq> members = new ArrayList<>();

        while (true) {
            System.out.println("1. 등록 2. 전체조회 3. 이름검색 4. 종료");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("이름: ");
                String name = sc.nextLine();

                // 중복 체크
                boolean dup = false;
                for (wlq r : members) {
                    if (r.getName().equals(name)) {
                        dup = true;
                        break;
                    }
                }

                if (dup) {
                    System.out.println("❌ 등록실패 : 이미 존재하는 이름입니다.");
                    continue;
                }

                System.out.print("전공: ");
                String major = sc.nextLine();

                System.out.print("기수: ");
                int gen = sc.nextInt();
                sc.nextLine();

                System.out.print("파트: ");
                String part = sc.nextLine();

                System.out.print("1. 아기사자 2. 운영진: ");
                int type = sc.nextInt();
                sc.nextLine();

                wlq member;

                if (type == 1) {
                    System.out.print("학번: ");
                    String studentId = sc.nextLine();
                    member = new Lion(name, major, gen, part, studentId);
                } else {
                    System.out.print("직책: ");
                    String pos = sc.nextLine();
                    member = new Staff(name, major, gen, part, pos);
                }

                members.add(member);
                System.out.println("✅ 등록 완료");

            } else if (choice == 2) {
                for (wlq r : members) {
                    r.printInfo();
                }

            } else if (choice == 3) {
                System.out.print("이름 검색: ");
                String search = sc.nextLine();

                boolean found = false;

                for (wlq r : members) {
                    if (r.getName().equals(search)) {
                        r.printInfo();
                        found = true;
                    }
                }

                if (!found) System.out.println("없음");

            } else if (choice == 0) break;
        }
        sc.close();
    }
}