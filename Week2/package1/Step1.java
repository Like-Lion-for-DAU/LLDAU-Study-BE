package Week2.package1;
import java.util.*;

class Lion {
    private String name;

    String major;

    public int generation;
    //Private, default, public 필드 선언 

    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }//생성자 선언
  
   public static void printInfo(Lion lion) {
        System.out.println("아기사자 이름: " + lion.name + 
                       ", 아기사자 전공: " + lion.major + 
                       ", 아기사자 기수: " + lion.generation);
        
    }

}

public class Step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("아기사자 이름을 입력해수세요");
        String name = sc.nextLine();

        System.out.println("아기사자의 전공을 입력해주세요");
        String major = sc.nextLine();

        System.out.println("아기사자의 기수를 입력해주세요");
        int generation = sc.nextInt();

        //유효성 검증
        if (name.trim().isEmpty()) {
            System.out.println("아기사자 이름은 필수 입력 항목입니다.");
        }
        else if(major.trim().isEmpty()){
            System.out.println("아기사자 전공은 필수 입력 항목입니다.");
        }
        else if(generation < 1){
            System.out.println("아기사자 기수는 양수로 입력해주세요.");
        }
        else{
            Lion babyLion = new Lion(name, major, generation);
            System.out.println("입력값 검증을 완료하여 객체를 생성합니다.");
            //데이터를 입력 받아 객체 생성

        }

        Lion.printInfo(new Lion(name, major, generation));

        sc.close();
        
    }
}
