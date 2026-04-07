package pk1;

import java.util.Scanner;

public class step1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("아기사자 이름을 입력해주세요: ");
        String name = scanner.nextLine();
        System.out.print("전공을 입력해주세요: ");
        String major = scanner.nextLine();
        System.out.print("기수를 입력해주세요: ");
        int num = scanner.nextInt();
        
        System.out.println("입력값 검증을 시작합니다.");
        if(name.isEmpty()){
            System.out.println("이름은 비어있을 수 없습니다");
        }
        else if(major.isEmpty()){
            System.out.println("전공은 비어있을 수 없습니다.");
        }
        else if(num<1){
            System.out.println("기수는 1이상이어야 합니다.");
        }
        else{
            System.out.println("입력값 검증을 통과하여 아기사자 객체 생성을 진행합니다.");
            lion l = new lion(name, major, num);
            System.out.println("아기사자 객체를 성공적으로 생성하였습니다.");
            l.p();
        }
    }
}