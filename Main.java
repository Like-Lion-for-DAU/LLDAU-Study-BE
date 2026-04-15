import java.util.Scanner;
class Lion{
    String name;
     void setName(String n) {
        name = n;
     }
     void checkName() {
        if(name.equals("아기사자")) {
            System.out.println("과제 제출 가능.");
        } else if(name.equals("운영진")) {
            System.out.println("과제 제출 불가.");
        } else {
            System.out.println("과제 없음.");
        }
        
     }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lion lion = new Lion();
        System.out.print("너의 역할은?: ");
        String input = sc.nextLine();
        lion.setName(input);
        lion.checkName();
        sc.close();
    }
}