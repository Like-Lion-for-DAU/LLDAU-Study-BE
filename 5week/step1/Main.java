import role.*;
import service.MemberService;
import util.MyScanner;

import java.util.List;

public class Main {
    private static final int REGISTER_NUM = 1;
    private static final int PRINT_ALL_NUM = 2;
    private static final int SEARCH_NUM = 3;
    private static final int ESCAPE_NUM = 4;

    private static final int LION_NUM = 1;
    private static final int STAFF_NUM = 2;

    private static final MyScanner scanner = new MyScanner();
    private static final MemberService memberService = new MemberService();

    public static void main(String[] args) {


        while(true) {
            int menu = scanner.scanInteger("골라.\n" +
                                            REGISTER_NUM + ". 멤버 등록\n" +
                                            PRINT_ALL_NUM + ". 전체 멤버 조회\n" +
                                            SEARCH_NUM   + ". 이름으로 멤버 검색\n" +
                                            ESCAPE_NUM + ". 종료");
            switch (menu) {
                case REGISTER_NUM:
                    int choice = scanner.scanInteger("역할 골라. " + LION_NUM + "은 아기사자, " + STAFF_NUM + "는 운영진: ");
                    if(choice == LION_NUM) {
                        Lion newLion = Lion.scan(scanner);
                        memberService.register(newLion);
                    } else if(choice == STAFF_NUM) {
                        Staff newStaff = Staff.scan(scanner);
                        memberService.register(newStaff);
                    }
                    break;
                case PRINT_ALL_NUM:
                    List<Role> members =  memberService.findAll();

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
                    String target = scanner.scanString("검색할 이름.");
                    Role member = memberService.findByName(target);
                    if(member == null) {
                        System.out.println("그런 거 없다.");
                    } else {
                        member.describeSelf();
                    }
                    break;
                case ESCAPE_NUM:
                    return;
            }
        }
    }
}
