package Week2.package2; 

import Week2.package1.Lion;  

public class Step3 {
    public static void main(String[] args) {
        Lion babyLion = new Lion("철수", "컴공", 1);

        
        babyLion.generation = 2;

        
        //babyLion.major = "경영";

        
        //babyLion.name = "영희";

        System.out.println("public 필드 접근 성공");
        System.out.println(babyLion.toString());
    }
}