import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("저장할 아기 사자 수를 5 이상 입력해주세요");
        int repeat = sc.nextInt();

        
        while (repeat < 5) {
            System.out.println("[오류] 5 이상 입력해주세요");
            System.out.println("5 이상 입력해주세요");
            repeat = sc.nextInt();
        }

        
        String[] babyLions = new String[repeat];

        System.out.println("아기 사자들의 이름을 입력해주세요");
        for (int i = 0; i < repeat; i++) {
            babyLions[i] = sc.next();
        }

        System.out.println("\n아기 사자 명단을 출력합니다.");
        for (int i = 0; i < repeat; i++) {
            System.out.println((i + 1) + ". " + babyLions[i]);
        }

        sc.close();
    }
}