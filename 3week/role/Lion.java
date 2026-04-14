package role;

import java.util.Scanner;

import policy.HomeworkPolicy;
import policy.LionHomeworkPolicy;

public class Lion extends Role {
    private String number;

    public Lion(String name, String major, Integer year, String part, String number) {
        super(name, major, year, part);
        this.number = number;
    }

    public static Lion scanLion(Scanner sc) {
        System.out.println("아기사자다.");
        System.out.println("이름. ");
        String name = sc.nextLine();
        System.out.println("전공. ");
        String major = sc.nextLine();
        System.out.println("기수. ");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("파트 (백엔드/프론트엔드/기획/디자인). ");
        String part = sc.nextLine();
        System.out.println("학번. ");
        String number = sc.nextLine();
        return new Lion(name, major, year, part, number);
    }

    @Override
    public HomeworkPolicy getHomeworkPolicy() {
        return new LionHomeworkPolicy();
    }

    @Override
    public String describeSelf() {
        String result = "";
        
        result = "나는 아기사자다.\n"
                + "이름: " + super.getName() + "\n"
                + "전공: " + super.getMajor() + "\n"
                + "기수: " + super.getYear() + "\n"
                + "파트: " + super.getPart() + "\n"
                + "학번: " + number + "\n"
                + "과제 제출: " + (isSubmittable() ? "가능" : "불가능") + "\n"
                + "이상.";
        
        return result;
    }
}
