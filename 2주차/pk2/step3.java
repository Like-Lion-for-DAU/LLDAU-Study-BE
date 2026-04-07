package pk2;

import java.util.Scanner;
import pk1.lion;

public class step3 {
    public static void main(String[] args) {
        System.out.println("아기사자 객체를 생성합니다.");
        lion l = new lion("김멋대", "컴퓨터공학과", 14);
        System.out.println("아기사자 정보를 출력합니다.");
        l.p();

        System.out.println("\nname 필드 변경");
        l.name = "김사자";
        System.out.println("public 필드 접근 성공");
        System.out.println("아기사자 정보를 출력합니다.");
        
        l.p();


    }
}