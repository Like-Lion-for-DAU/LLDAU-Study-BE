import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name,major,part,pos;
        int num, index;

        System.out.println("====== 아기사자 정보 입력 ======");
        System.out.print("이름 : ");
        name = sc.nextLine();

        System.out.print("전공 : ");
        major = sc.nextLine();

        System.out.print("기수 : ");
        num = sc.nextInt();
        sc.nextLine();

        System.out.print("파트 : ");
        part = sc.nextLine();

        System.out.print("학번 : ");
        index = sc.nextInt();
        sc.nextLine();

        Lion l = new Lion(name, major, num, part, index);


        System.out.println("====== 운영진 정보 입력 ======");
        System.out.print("이름 : ");
        name = sc.nextLine();

        System.out.print("전공 : ");
        major = sc.nextLine();

        System.out.print("기수 : ");
        num = sc.nextInt();
        sc.nextLine();


        System.out.print("파트 : ");
        part = sc.nextLine();

        System.out.print("직책 : ");
        pos = sc.nextLine();

        Manager m = new Manager(name, major, num, part, pos);

        System.out.println("====== 결과 출력 ======");
        System.out.println(l.getInfo());
        l.canSubmit();
        System.out.println("------------------------------");
        System.out.println(m.getInfo());
        m.canSubmit();


    }
}
