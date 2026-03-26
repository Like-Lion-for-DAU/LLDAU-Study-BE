import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        // Scanner 객체 생성
        Scanner sc = new Scanner(System.in);
        int num = 0;

        // 프로그램이 종료('exit')될 때까지 계속 실행
        while (true) {

            System.out.println("저장할 아기사자 수를 5이상 입력 해 주세요. ");
            try{

                num = sc.nextInt();

                // 입력받은 숫자가 5 미만일 경우 처리
                if (num < 5) {
                    System.out.println("[오류] 5이상 입력해 주세요! ");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                // 사용자가 숫자가 아닌 문자 등을 입력했을 때 발생하는 에러(예외) 처리
                System.out.println("[오류] 숫자로만 입력해 주세요!");
                sc.nextLine(); // 잘못 입력된 버퍼 비우기 (무한 루프 방지)
                continue;
            }

            // nextInt() 사용 후 버퍼에 남아있는 엔터 키(\n)를 제거하기 위해 호출
            sc.nextLine();

            String[] babylions = new String[num];
            System.out.println("아기사자의 이름을 입력해 주세요: ");
            for (int i = 0; i < num; i++) {

                // .trim()으로 입력값 앞뒤의 무의미한 공백(띄어쓰기)을 제거
                String inputName = sc.nextLine().trim();

                // 빈칸(엔터 또는 공백만 입력)인지 검사
                if (inputName.isEmpty()) {
                    System.out.println("[오류] 이름은 빈칸입니다. 다시 입력해 주세요.");
                    i--;
                    continue;
                }

                // 중복 검사 (지금까지 입력된 배열의 내용과 비교)
                boolean isDuplicate = false; // 중복 여부를 체크할 스위치
                for (int j = 0; j < i; j++) {
                    // 방금 입력한 이름(inputName)이 기존 배열(babylions[j])에 있는지 확인
                    if (babylions[j].equals(inputName)) {
                        isDuplicate = true;
                        break; // 중복을 하나라도 발견하면 더 찾을 필요 없이 반복 종료
                    }
                }

                // 중복일 경우의 처리
                if (isDuplicate) {
                    System.out.println("[오류] 이미 등록된 이름입니다. 다른 이름을 입력해 주세요.");
                    i--;
                    continue;
                }

                // 빈칸도 아니고, 중복도 아니라면 안전하게 배열에 저장
                babylions[i] = inputName;


            }

            System.out.println("아기사자의 명단을 최종적으로 출력합니다.");
            for (int i = 0; i < num; i++) {
                System.out.println((i + 1) + ". " + babylions[i]);
            }

            // 프로그램 계속 진행 여부 확인
            System.out.println("프로그램을 종료하려면 'exit'를 입력하세요.");
            System.out.println("계속 아기사자를 등록하려 'restart'를 입력하세요.");
            String exit_or_restart = sc.next();

            if (exit_or_restart.equals("restart")) {
                continue; // while 루프의 제일 처음 부분으로 돌아가서 프로그램 재시작
            }

            if (exit_or_restart.equals("exit")) {
                sc.close();
                break; // 가장 바깥의 while(true) 무한 루프를 탈출하여 프로그램 최종 종료
            }

        }
    }
}