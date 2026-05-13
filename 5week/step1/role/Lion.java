package role;

import java.util.Scanner;

import policy.*;
import util.MyScanner;

public class Lion extends Role {
    private String number;

    public Lion(String name, String major, Integer year, String part, String number) {
        super(name, major, year, part);
        this.number = number;
    }

    public static Lion scan(MyScanner sc) {
        System.out.println("아기사자다.");
        String name = sc.scanString("이름. ");
        String major = sc.scanString("전공. ");
        Integer year = sc.scanInteger("기수. ");
        String part = sc.scanString("파트 (백엔드/프론트엔드/기획/디자인). ");
        String number = sc.scanString("학번. ");

        return new Lion(name, major, year, part, number);
    }

    @Override
    public HomeworkPolicy getHomeworkPolicy() {
        return new LionHomeworkPolicy();
    }

    @Override
    public void describeSelf() {
        System.out.println("나는 아기사자다.\n"
                + "이름: " + super.getName() + "\n"
                + "전공: " + super.getMajor() + "\n"
                + "기수: " + super.getYear() + "\n"
                + "파트: " + super.getPart() + "\n"
                + "학번: " + number + "\n"
                + "과제 제출: " + (isSubmittable() ? "가능" : "불가능") + "\n"
                + "이상.");
    }
}
