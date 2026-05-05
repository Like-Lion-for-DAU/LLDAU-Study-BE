package role;

import java.util.List;
import java.util.Scanner;

import policy.AdminHomeworkPolicy;
import policy.HomeworkPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, Integer year, String part, String position) {
        super(name, major, year, part);
        this.position = position;
    }

    public static Staff scan(Scanner sc, List<Role> members) {
        System.out.println("운영진이다.");

        System.out.println("이름. ");
        String name = sc.nextLine();
        assertNameUnique(members, name);

        System.out.println("전공. ");
        String major = sc.nextLine();

        System.out.println("기수. ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.println("파트 (백엔드/프론트엔드/기획/디자인). ");
        String part = sc.nextLine();

        System.out.println("직책 (대표/부대표/파트장/멘토). ");
        String position = sc.nextLine();

        return new Staff(name, major, year, part, position);
    }

    public static void register(List<Role> members, Staff staff) {
        members.add(staff);
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
