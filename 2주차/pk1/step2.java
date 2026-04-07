package pk1;

import java.util.Scanner;

public class step2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("아기사자 이름을 입력해주세요: ");
        String name = scanner.nextLine();
        System.out.print("전공을 입력해주세요: ");
        String major = scanner.nextLine();
        System.out.print("기수를 입력해주세요: ");
        int num = scanner.nextInt();
        
        lion l = new lion(name, major, num);
        l.check(name,major,num);

    }
}