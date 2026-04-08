// 접근 제어자 확인 (다른 패키지)
//java -cp . package2.step3(step3.java 파일이 있는 위치에서 명령어 실행)
package package2;

import package1.Lion;

public class step3 {
    public static void main(String[] args) {

        System.out.println("🦁 아기사자 객체를 생성합니다.");

        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);

        System.out.println("🦁 아기사자 정보를 출력합니다.");
        lion.printInfo();

        System.out.println("\n📌 Step 3-1. public 필드 접근을 시도합니다.");
        System.out.println("👉 name 필드 값을 변경합니다.");

        // ✅ public → 가능
        lion.name = "홍길동";

        System.out.println("✅ public 필드 접근 성공");

        System.out.println("🦁 아기사자 정보를 출력합니다.");
        lion.printInfo();

        //default 접근 시도 (아래 주석 해제 시 컴파일 에러 발생)
        //lion.major = "소프트웨어공학과";

        //private 접근 시도 (아래 주석 해제 시 컴파일 에러 발생)
        //lion.generation = 20;
    }
}