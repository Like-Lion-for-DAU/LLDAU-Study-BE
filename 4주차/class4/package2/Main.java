package class4.package2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import class4.role.Role;
import class4.role.Lion;
import class4.role.Staff;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Role> memberList = new ArrayList<Role>();
        Map<String, List<Role>> partMap = new HashMap<String, List<Role>>();

        while (true) {
            System.out.println("======= 멤버 관리 시스템 =======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                System.out.println("-- 멤버 등록 --");
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = sc.nextInt();
                sc.nextLine();

                System.out.print("이름: ");
                String name = sc.nextLine();

                boolean isDuplicate = false;

                for (Role member : memberList) {
                    if (member.getName().equals(name)) {
                        isDuplicate = true;
                    }
                }

                if (isDuplicate) {
                    System.out.println("등록 실패: 이미 존재하는 이름입니다.");
                    System.out.println();
                    continue;
                }

                System.out.print("전공: ");
                String major = sc.nextLine();

                System.out.print("기수: ");
                int generation = sc.nextInt();
                sc.nextLine();

                System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
                String part = sc.nextLine();

                Role member = null;

                if (roleChoice == 1) {
                    System.out.print("학번: ");
                    String studentId = sc.nextLine();

                    member = new Lion(name, major, generation, part, studentId);
                } else if (roleChoice == 2) {
                    System.out.print("직책 (대표/부대표/파트장/멘토): ");
                    String position = sc.nextLine();

                    member = new Staff(name, major, generation, part, position);
                }

                if (member != null) {
                    memberList.add(member);

                    if (!partMap.containsKey(part)) {
                        partMap.put(part, new ArrayList<Role>());
                    }

                    partMap.get(part).add(member);

                    System.out.println("등록 완료: " + member.getName());
                }

                System.out.println();

            } else if (menu == 2) {
                System.out.println("-- 전체 멤버 목록 --");

                if (memberList.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.");
                } else {
                    int number = 1;

                    for (Role member : memberList) {
                        System.out.println(number + ". [" + member.getRoleName() + "] "
                                + member.getName() + " - " + member.getGeneration() + "기");
                        number++;
                    }

                    System.out.println("총 " + memberList.size() + "명");
                }

                System.out.println();

            } else if (menu == 3) {
                System.out.println("-- 이름으로 검색 --");
                System.out.print("검색할 이름: ");
                String searchName = sc.nextLine();

                Role foundMember = null;

                for (Role member : memberList) {
                    if (member.getName().equals(searchName)) {
                        foundMember = member;
                    }
                }

                if (foundMember == null) {
                    System.out.println("검색 결과가 없습니다.");
                } else {
                    System.out.println();
                    System.out.println("[검색 결과]");
                    System.out.println("역할: " + foundMember.getRoleName());
                    System.out.println(foundMember.getDetailInfo());
                    System.out.println("과제 제출 가능 여부: "
                            + (foundMember.canSubmitAssignment() ? "가능" : "불가능"));
                }

                System.out.println();

            } else if (menu == 4) {
                System.out.println("-- 파트별 조회 --");
                System.out.println("등록된 파트: " + partMap.keySet());

                System.out.print("조회할 파트: ");
                String searchPart = sc.nextLine();

                if (!partMap.containsKey(searchPart)) {
                    System.out.println("해당 파트에 등록된 멤버가 없습니다.");
                } else {
                    System.out.println();
                    System.out.println("[" + searchPart + " 파트 멤버]");

                    List<Role> partMembers = partMap.get(searchPart);
                    int number = 1;

                    for (Role member : partMembers) {
                        System.out.println(number + ". " + member.getName()
                                + " (" + member.getRoleName() + ") - "
                                + member.getGeneration() + "기");
                        number++;
                    }
                }

                System.out.println();

            } else if (menu == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다.");
                System.out.println();
            }
        }

        sc.close();
    }
}