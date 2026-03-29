import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int repeat;
        while (true) {
            System.out.println("저장할 아기사자 수를 5 이상 입력해주세요.");
            repeat = sc.nextInt();

            if (repeat >= 5) {
                break;
            } else {
                System.out.println("[오류] 5 이상 입력해주세요.");
            }
        }

        String[] babyLions = new String[repeat];
        
        System.out.println("아기사자 이름을 입력해주세요.");
        for (int i = 0; i < repeat; i++) {
            babyLions[i] = sc.next();
        }

        System.out.println("\n아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0; i < babyLions.length; i++) {
            System.out.println((i + 1) + ". " + babyLions[i]);
        }

        sc.close();
    }
}