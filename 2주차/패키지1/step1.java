package 패키지1;
import java.util.Scanner;

public class step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 입력: ");
        String name = sc.nextLine();

        System.out.print("전공 입력: ");
        String major = sc.nextLine();

        System.out.print("기수 입력: ");
        int generation = sc.nextInt();

        if (name == null || name.isEmpty()) {
            System.out.println("❌ 이름이 비어 있습니다.");
            return;
        }

        if (major == null || major.isEmpty()) {
            System.out.println("❌ 전공이 비어 있습니다.");
            return;
        }

        if (generation < 1) {
            System.out.println("❌ 기수는 1 이상이어야 합니다.");
            return;
        }

        System.out.println("입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
        Lion lion = new Lion(name, major, generation);
        System.out.println("아기 사자 정보를 출력합니다.\n");
        System.out.println("이름: " + lion.name + " | 전공: " + lion.major + " | 기수: " + generation);

    }
}
