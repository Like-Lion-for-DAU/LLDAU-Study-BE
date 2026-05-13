package role;

import policy.AdminHomeworkPolicy;
import policy.HomeworkPolicy;
import util.MyScanner;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, Integer year, String part, String position) {
        super(name, major, year, part);
        this.position = position;
    }

    public static Staff scan(MyScanner sc) {
        System.out.println("운영진이다.");
        String name = sc.scanString("이름. ");
        String major = sc.scanString("전공. ");
        Integer year = sc.scanInteger("기수. ");
        String part = sc.scanString("파트 (백엔드/프론트엔드/기획/디자인). ");
        String position = sc.scanString("직책 (대표/부대표/파트장/멘토). ");

        return new Staff(name, major, year, part, position);
    }

    public void printOverview() {
        System.out.println("["+"운영진"+"] " + getName() + " - " + getYear() + "기");
    }

    @Override
    public HomeworkPolicy getHomeworkPolicy() {
        return new AdminHomeworkPolicy();
    }

    @Override
    public void describeSelf() {
        System.out.println("나는 운영진이다.\n"
                + "이름: " + getName() + "\n"
                + "전공: " + getMajor() + "\n"
                + "기수: " + getYear() + "\n"
                + "파트: " + getPart() + "\n"
                + "직책: " + position + "\n"
                + "과제 제출: " + (isSubmittable() ? "가능" : "불가능") + "\n"
                + "이상.");
    }
}
