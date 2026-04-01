import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int count = 0;

            // 아기사자 수 입력
            while (true) {
                System.out.println("저장할 아기사자 수를 5 이상 입력해주세요.");

                if (sc.hasNextInt()) {
                    count = sc.nextInt();
                    sc.nextLine();

                    if (count >= 5) {
                        break;
                    } else {
                        System.out.println("[오류] 5 이상 입력해주세요.");
                    }
                } else {
                    System.out.println("[오류] 숫자만 입력할 수 있습니다.");
                    sc.nextLine();
                }
            }

            String[] lionList = new String[count];

            System.out.println("아기사자 이름을 입력해주세요.");

            // 이름 입력
            for (int i = 0; i < count; i++) {
                while (true) {
                    String name = sc.nextLine();

                    if (name.equals("")) {
                        System.out.println("이름이 비어있습니다. 다시 입력해주세요.");
                        continue;
                    }

                    boolean sameName = false;

                    for (int j = 0; j < i; j++) {
                        if (lionList[j].equals(name)) {
                            sameName = true;
                        }
                    }

                    if (sameName) {
                        System.out.println("이미 등록된 이름입니다. 다시 입력해주세요.");
                    } else {
                        lionList[i] = name;
                        break;
                    }
                }
            }

            // 최종 명단 출력
            System.out.println("아기사자 명단을 최종적으로 출력합니다.");

            for (int i = 0; i < lionList.length; i++) {
                System.out.println((i + 1) + ". " + lionList[i]);
            }

            // 종료 또는 재시작
            while (true) {
                System.out.println("=======================");
                System.out.println("프로그램을 종료하려면 'exit'를 입력하세요.");
                System.out.println("계속 아기사자를 등록하려면 'restart'를 입력하세요.");

                String answer = sc.nextLine();

                if (answer.equals("exit")) {
                    System.out.println("아기사자 명단 관리 프로그램을 종료합니다.");
                    sc.close();
                    return;
                } else if (answer.equals("restart")) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            }
        }
    }
}