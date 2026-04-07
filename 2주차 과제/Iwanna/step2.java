package Iwanna;

import java.util.Scanner;

public class step2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String name = sc.next();

        System.out.println("🎓 전공을 입력해주세요.");
        String major = sc.next();

        System.out.println("📌 기수를 입력해주세요.");
        int number = sc.nextInt();

        Lion lion = new Lion(name, major, number);

        System.out.println("⏩ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        if (lion.Validation() == false) {
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
            return;
        }

        System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");

        System.out.println("🦁 아기사자 정보를 출력합니다.");

        System.out.print("👤 이름 : "+lion.name);
        System.out.print("| 🎓 전공 : "+lion.major);
        //System.out.print("| 📌 기수 : "+lion.number);


    }
}
 
