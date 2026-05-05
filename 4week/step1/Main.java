package step1;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int REGISTER_NUM = 1;
    private static final int PRINT_ALL_NUM = 2;
    private static final int SEARCH_NUM = 3;
    private static final int ESCAPE_NUM = 4;

    private static final int LION_NUM = 1;
    private static final int STAFF_NUM = 2;

    private static final Scanner scanner = new Scanner(System.in);

    private static List<Role> members = new ArrayList<>();

    public static void main(String[] args) {


        while(true) {
            System.out.println(
                    "골라.\n" +
                    REGISTER_NUM + ". 멤버 등록\n" +
                    PRINT_ALL_NUM + ". 전체 멤버 조회\n" +
                    SEARCH_NUM   + ". 이름으로 멤버 검색\n" +
                    ESCAPE_NUM + ". 종료"
            );

            int menu = scanner.nextInt();
            scanner.nextLine();
            switch (menu) {
                case REGISTER_NUM:
                    System.out.println("역할 골라. " + LION_NUM + "은 아기사자, " + STAFF_NUM + "는 운영진: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    if(choice == LION_NUM) {
                        Lion newLion = Lion.scan(scanner, members);
                        Lion.register(members, newLion);
                    } else if(choice == STAFF_NUM) {
                        Staff newStaff = Staff.scan(scanner, members);
                        Staff.register(members, newStaff);
                    }
                    break;
                case PRINT_ALL_NUM:
                    if(members.isEmpty()) {
                        System.out.println("등록부터 햐.");
                    } else {
                        for (Role member : members) {
                            String role = member instanceof Lion ? "아기사자" : "운영진";
                            System.out.println("["+role+"] " + member.getName() + " - " + member.getYear() + "기");
                        }
                        System.out.println("총 " + members.size() + "명");
                    }
                    break;
                case SEARCH_NUM:
                    System.out.println("검색할 이름. ");
                    String target = scanner.nextLine();

                    boolean found = false;
                    for(Role member: members) {
                        if(member.getName().equals(target)) {
                            member.describeSelf();
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("그런 거 없다.");
                    }
                    break;
                case ESCAPE_NUM:
                    return;
            }
        }
    }
}
