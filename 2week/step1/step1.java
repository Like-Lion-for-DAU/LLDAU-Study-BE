package step1;

import java.util.Scanner;

public class step1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. 아기사자 정보 입력 받기
        System.out.println("이름.");
        String name = sc.nextLine();

        System.out.println("전공.");
        String major = sc.nextLine();

        System.out.println("기수.");
        Integer year = Integer.parseInt(sc.nextLine());

        // 2. (유효성 검증)? 오류 메시지 출력 : Lion 생성
        if(name.isEmpty() || major.isEmpty() || year < 1) {
            System.out.println("오류: 답변이 이상함. 아기사자가 될 자격 없음.");
        } else {
            Lion lion = new Lion(name, major, year);
            System.out.println("환영한다. " + year + "기 " +  major + " " + name);
        }
    }
}
