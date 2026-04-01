import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count;

        // 1. 아기사자 수 입력
        while (true) {
            System.out.print("🦁 저장할 아기사자 수를 5 이상 입력해주세요.");
            count = sc.nextInt();

            if (count >= 5) {
                break;
            } else {
                System.out.println("❗ [오류] 5 이상 입력해주세요.");
            }
        }

        
        String[] lions = new String[count];

        // 2. 아기사자 이름 입력
        sc.nextLine();
        System.out.println("✏️아기사자 이름을 입력해주세요.");
        for (int i = 0; i < count; i++) {
            lions[i] = sc.nextLine();
        }

        // 3. 최종 아기사자 명단 출력
        System.out.println("\n📑 아기사자 명단을 최종적으로 출력합니다.");
        //System.out.println("총 인원: " + count + "명");

        for (int i = 0; i < count; i++) {
            System.out.println("🦁 " + (i + 1) + ". " + lions[i]);
        }

        // 4. 프로그램 종료
        sc.close();
    }
}