import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 0;

        while (true) {

            System.out.println("저장할 아기사자 수를 5이상 입력 해 주세요. ");
            try{

                num = sc.nextInt();

                if (num < 5) {
                    System.out.println("[오류] 5이상 입력해 주세요! ");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("[오류] 숫자로만 입력해 주세요!");
                sc.nextLine(); // 잘못 입력된 버퍼 비우기 (무한 루프 방지)
                continue;
            }

            sc.nextLine();

            String[] str = new String[num];
            System.out.println("아기사자의 이름을 입력해 주세요: ");
            for (int i = 0; i < num; i++) {

                // .trim()으로 입력값 앞뒤의 무의미한 공백(띄어쓰기)을 제거
                String inputName = sc.nextLine().trim();

                // 1. 빈칸(엔터 또는 공백만 입력)인지 검사
                if (inputName.isEmpty()) {
                    System.out.println("[오류] 이름은 빈칸입니다. 다시 입력해 주세요.");
                    i--; // 현재 인덱스를 차감하여 이번 순서를 다시 반복하도록 함
                    continue;
                }

                // 2. 중복 검사 (지금까지 입력된 배열의 내용과 비교)
                boolean isDuplicate = false; // 중복 여부를 체크할 스위치
                for (int j = 0; j < i; j++) {
                    // 방금 입력한 이름(inputName)이 기존 배열(str[j])에 있는지 확인
                    if (str[j].equals(inputName)) {
                        isDuplicate = true;
                        break; // 중복을 하나라도 발견하면 더 찾을 필요 없이 반복 종료
                    }
                }

                if (isDuplicate) {
                    System.out.println("[오류] 이미 등록된 이름입니다. 다른 이름을 입력해 주세요.");
                    i--; // 현재 인덱스를 차감하여 다시 입력받음
                    continue;
                }

                // 빈칸도 아니고, 중복도 아니라면 안전하게 배열에 저장
                str[i] = inputName;


            }

            System.out.println("아기사자의 명단을 최종적으로 출력합니다.");
            for (int i = 0; i < num; i++) {
                System.out.println((i + 1) + ". " + str[i]);
            }

            System.out.println("프로그램을 종료하려면 'exit'를 입력하세요.");
            System.out.println("계속 아기사자를 등록하려 'restart'를 입력하세요.");

            String exit_or_restart = sc.next();

            if (exit_or_restart.equals("restart")) {
                continue;
            }

            if (exit_or_restart.equals("exit")) {
                sc.close();
                break;
            }

        }
    }
}