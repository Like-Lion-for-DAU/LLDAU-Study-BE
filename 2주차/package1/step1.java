package package1;

import java.util.Scanner;

public class step1 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("아기사자 이름을 입력해주세요: ");
        String name = sc.nextLine();
        System.out.println("전공을 입력해주세요: ");
        String major = sc.nextLine();
        System.out.println("기수를 입력: ");
        int gen = sc.nextInt();

        System.out.println("입력값 검증을 진행합니다.");
        // 조건 중 하나라도 만족하면 객체 생성 단계를 아예 실행하지 않음
        if (name.isEmpty() || major.isEmpty() || gen<1){
            System.out.println("오류: 유효하지 않은 입력입니다. 객체를 생성하지 않습니다.");
        }

        else{
            // 모든 검증을 통과한 경우에만 아래 로직이 실행됨
            System.out.println("입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
            System.out.println("아기사자 객체를 성공적으로 생성하였습니다.");
            Lion lion = new Lion(name, major, gen);
            // 생성된 객체의 정보를 출력
            lion.printInfo();
        }



    }

}