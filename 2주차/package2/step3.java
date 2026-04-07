package package2;

import package1.Lion;

import java.util.Scanner;

public class step3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("아기사자 이름을 입력해주세요: ");
        String name = sc.nextLine();
        System.out.println("전공을 입력해주세요: ");
        String major = sc.nextLine();
        System.out.println("기수를 입력: ");
        int gen = sc.nextInt();

        // 외부(다른 패키지)의 클래스를 사용하여 Lion 객체 생성
        Lion lion = new Lion(name, major, gen);


        // public 필드: 접근 가능
        System.out.println("name 필드값을 변경합니다.");
        lion.name = "수정된 이름을 가진 아기사자.";
        lion.printInfo();

        // default 필드 : 다른 패키지이므로 컴파일 에러 발생!
        // lion.major = "컴퓨터공학"; // <-- 주석 해제 시 에러 발생

        // private 필드 : 클래스 외부이므로 무조건 컴파일 에러!
        // lion.generation = 13;      // <-- 주석 해제 시 에러 발생
    }
}
