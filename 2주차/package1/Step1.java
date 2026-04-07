package package1;

import java.util.Scanner;

public class Step1 {
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

        System.out.println("입력값 검증을 진행합니다.");

        if (name.isEmpty()) {
            System.out.println("이름은 비어 있을 수 없습니다.");
        } else if (major.isEmpty()) {
            System.out.println("전공은 비어 있을 수 없습니다.");
        } else if (generation < 1) {
            System.out.println("기수는 1 미만일 수 없습니다.");
        } else {
            System.out.println("입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
            System.out.println("아기사자 객체를 성공적으로 생성하였습니다.");
            
            Lion lion = new Lion(name, major, generation);
            
            System.out.println("아기사자 정보를 출력합니다.");
            System.out.printf("이름: %s | 전공: %s | 기수: %d\n", 
                               lion.name, major, generation);
        }
        
        System.out.println("\n종료 코드 0(으)로 완료된 프로세스");
    }
}