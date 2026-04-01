import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        ArrayList<String> namelist = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            
            System.out.println("🦁 저장할 아기 사자 수를 5 이상 입력해주세요.");
            int N = sc.nextInt();

            if (N < 5) {
                System.out.println("❗️ [오류] 5 이상 입력해주세요.");
            } else {
                System.out.println("✏️ 아기사자 이름을 입력해주세요.");

                for (int i = 0; i < N; i++) {
                    String name = sc.next();
                    namelist.add(name);
                }

                System.out.println("📋 아기사자 명단을 최종적으로 출력합니다.");
                for (int j = 0; j < N; j++) {
                    System.out.printf("🦁 %d. %s\n", j + 1, namelist.get(j));
                }
                break;
            }
        }
    }
}