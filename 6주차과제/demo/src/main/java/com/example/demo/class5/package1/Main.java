package com.example.demo.class5.package1;

import com.example.demo.class5.role.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.class5")
public class Main implements CommandLineRunner {

    private final MemberService service;

    public Main(MemberService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("Bean 가져오기 성공: " + service);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. 등록 2. 전체조회 3. 이름검색 0. 종료");
            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {

                System.out.print("역할선택 (1: 아기사자 / 2: 운영진): ");
                int role = sc.nextInt();
                sc.nextLine();

                System.out.print("이름: ");
                String name = sc.nextLine();

                System.out.print("전공: ");
                String major = sc.nextLine();

                System.out.print("기수: ");
                int generation = sc.nextInt();
                sc.nextLine();

                System.out.print("파트: ");
                String part = sc.nextLine();

                System.out.print("학번: ");
                String studentId = sc.nextLine();

                wlq member = (role == 1)
                        ? new Lion(name, major, generation, part, studentId)
                        : new Staff(name, major, generation, part, studentId);

                service.register(member);

            } else if (menu == 2) {

                for (wlq member : service.getAllMembers()) {
                    System.out.println(member);
                }

            } else if (menu == 3) {

                System.out.print("검색할 이름: ");
                String name = sc.nextLine();

                wlq member = service.searchByName(name);

                if (member == null) System.out.println("해당 멤버가 없습니다.");
                else System.out.println(member);

            } else if (menu == 0) {

                System.out.println("프로그램 종료");
                break;
            }
        }

        sc.close();
    }
}