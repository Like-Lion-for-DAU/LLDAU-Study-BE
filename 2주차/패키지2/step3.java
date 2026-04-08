package 패키지2;

import 패키지1.Lion;

public class step3 {
    public static void main(String[] args) {
        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);

        System.out.println("🦁 아기사자 객체를 생성합니다.");
        lion.printInfo();

        System.out.println("\n Step 3-1. public 필드 접근을 시도합니다.");
        lion.name = "다른 패키지에서 변경된 이름";
        System.out.println("✅ public 필드 접근 성공");

        System.out.println("\n Step 3-2. default 필드 접근을 시도합니다.");
        // lion.major = "다른 패키지에서 변경된 전공"; // 컴파일 에러 발생
        System.out.println("❌ default 필드 접근 불가");

        System.out.println("\n Step 3-3. private 필드 접근을 시도합니다.");
        // lion.generation = 20; // 컴파일 에러 발생
        System.out.println("❌ private 필드 접근 불가");

        System.out.println("아기 사자 정보를 출력합니다.\n");
        System.out.println("이름: " + lion.name + " | 전공: " + lion.major + " | 기수: " + generation);
    }
}
