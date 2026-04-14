package step2;

import java.util.Scanner;

public class step2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. 아기사자 정보 입력 받기
        System.out.println("이름.");
        String name = sc.nextLine();

        System.out.println("전공.");
        String major = sc.nextLine();

        System.out.println("기수.");
        Integer year = Integer.parseInt(sc.nextLine());

        // 2. Lion 생성 (유효성 검증은 객체 내부로 이동함)
        Lion lion = new Lion(name, major, year);
    }
}
