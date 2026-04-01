import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("저장할 아기사자 수를 5 이상 입력해주세요: ");
            n = sc.nextInt();
            sc.nextLine();

            if (n < 5) {
                System.out.println("❕ [오류] 5 이상 입력해주세요.");
            }
        } while (n < 5);

        String[] lions = new String[n];
        int i = 0;

        while (i < n) {
            System.out.print((i + 1) + ": ");
            lions[i] = sc.nextLine();
            i++;
        }

        System.out.println("\n아기사자 명단을 최종적으로 출력합니다.");

        i = 0;
        while (i < n) {
            System.out.println((i + 1) + ". " + lions[i]);
            i++;
        }

        sc.close();
    }
}