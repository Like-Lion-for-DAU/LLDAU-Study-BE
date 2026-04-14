package step3;

import java.util.Scanner;

public class step3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. 아기사자 정보 입력 받기
        System.out.println("이름.");
        String name = sc.nextLine();

        System.out.println("전공.");
        String major = sc.nextLine();

        System.out.println("기수.");
        Integer year = Integer.parseInt(sc.nextLine());

        // 2. 비교를 위해 같은 패키지의 lion과 다른 패키지의 lion을 생성한다.
        Lion lion = new Lion(name, major, year);
        step2.Lion foreignLion = new step2.Lion(name, major, year);

        /* 아래 문장은 주석을 해제할 경우 접근 제어자로 인한 컴파일 오류가 발생한다. default는 다른 패키지에서 접근할 수 없기 때문이다.
         * lion.major = foreignLion.major;
         *              ~~~~~~~~~~~~~~~~~
        */
    }
}
