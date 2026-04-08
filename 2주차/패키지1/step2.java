package 패키지1;
import java.util.Scanner;

public class step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 입력: ");
        String name = sc.nextLine();

        System.out.print("전공 입력: ");
        String major = sc.nextLine();

        System.out.print("기수 입력: ");
        int generation = sc.nextInt();

        Lion lion = new Lion(name, major, generation);
        System.out.println("객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        if (!lion.validate()) {
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
            return;
        }

        System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
        System.out.println("아기 사자 정보를 출력합니다.\n");
        System.out.println("이름: " + lion.name + " | 전공: " + lion.major + " | 기수: " + generation);
    }
}
