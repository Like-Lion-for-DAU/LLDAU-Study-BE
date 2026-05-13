import java.util.Scanner;

public class Sub {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 저장소 선택
        MemberRepository repository = new MemoryMemberRepository();

        // 생성자 주입(DI)
        MemberService service = new MemberService(repository);

        System.out.print("멤버의 수는? ");
        int j = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < j; i++) {

            System.out.print("이름을 입력하세요: ");
            String name = sc.nextLine();

            System.out.print("학번을 입력하세요: ");
            String studentId = sc.nextLine();

            System.out.print("파트를 입력하세요:(백엔드, 프론트엔드, 설계) ");
            String part = sc.nextLine();

            service.addMember(name, studentId, part);
        }

        System.out.print("조회할 파트를 입력하세요: ");
        String searchPart = sc.nextLine();

        service.printMembersByPart(searchPart);
    }
}