// 객체 검증
// java -cp . package1.step2(step2.java 파일이 있는 위치에서 명령어 실행)
package package1;

import java.util.Scanner;

public class step2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String name = sc.nextLine();

        System.out.println("🎓 전공을 입력해주세요.");
        String major = sc.nextLine();

        System.out.println("📌 기수를 입력해주세요.");
        int generation = sc.nextInt();

        // 🔥 먼저 객체 생성
        System.out.println("▶️ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        Lion lion = new Lion(name, major, generation);

        // 🔥 객체가 검증
        if (!lion.validate()) {
            return;
        }

        System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
        System.out.println("🦁 아기사자 정보를 출력합니다.");

        lion.printInfo();
    }
}