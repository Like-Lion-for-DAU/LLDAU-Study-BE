package package2;

import package1.Lion; 

public class Step3 {
    public static void main(String[] args) {
        System.out.println("아기사자 객체를 생성합니다.");
        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);
        lion.printInfo(); 
        System.out.println(); 

        // public 필드 접근 시도 및 변경
        System.out.println("public 필드 접근을 시도합니다.");
        System.out.println("name 필드 값을 변경합니다.");
        
        lion.name = "홍길동"; 
        
        System.out.println("public 필드 접근 성공");
        lion.printInfo();

        // lion.major = "산업디자인"; // default 접근 불가
        // lion.generation = 13; // private 접근 불가
    }
}