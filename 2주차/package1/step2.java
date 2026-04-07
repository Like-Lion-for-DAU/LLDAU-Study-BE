package package1;

import java.util.Scanner;

//특징: 객체를 생성하기전, 검증을 거쳤던 Step1과는 달리 입력값과 상관없이 'Lion' 객체를 먼저 생성하고, 객체 스스로 유효성을 검사하게 함
public class step2 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("아기사자 이름을 입력해주세요: ");
        String name = sc.nextLine();
        System.out.println("전공을 입력해주세요: ");
        String major = sc.nextLine();
        System.out.println("기수를 입력: ");
        int gen = sc.nextInt();

        Lion lion = new Lion(name, major, gen);

        //lion 객체의 isValid() 메서드를 호출함
        if (lion.isValid()) {
            // isValid() 내부에서 통과(true)되었을 때 실행
            System.out.println("아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            lion.printInfo();
        }
        else{
            // isValid() 내부에서 조건에 걸려 false를 반환했을 때 실행
            System.out.println("잘못된 아기사자 정보입니다.");
        }

    }

}
