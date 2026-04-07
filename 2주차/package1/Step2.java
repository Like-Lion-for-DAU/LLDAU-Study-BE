package package1;

import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");

        System.out.println("아기사자 이름을 입력해주세요.");
        String name = sc.nextLine();

        System.out.println("전공을 입력해주세요.");
        String major = sc.nextLine();

        System.out.println("기수를 입력해주세요.");
        int generation = 0;
        if (sc.hasNextInt()) { 
            generation = sc.nextInt();
        } else {
            sc.next(); // 잘못된 입력 버림
            generation = -1; // 잘못된 형식 입력 시 검증에서 걸리도록 설정
        }

        Lion lion = new Lion(name, major, generation);
        System.out.println("객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        if (lion.checkSelfStatus()) {
            System.out.println("아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            lion.printInfo();
        }

        System.out.println("\n종료 코드 0(으)로 완료된 프로세스");
    }
}