package pk1;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Role> list = new ArrayList<Role>();

    public static void selectLion(){
        System.out.print("이름 : ");
        String name = sc.nextLine();
        for(Role r : list){
            if(r.name.equals(name)){
                System.out.println("등록 실패 : 이미 존재하는 이름입니다.");
                return;
            }
        }
        System.out.print("전공 : ");
        String major = sc.nextLine();
        System.out.print("기수 : ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 : ");
        String part = sc.nextLine();
        System.out.print("학번 : ");
        int index = sc.nextInt();
        sc.nextLine();
        list.add(new Lion(1,name,major,num,part,index));
    }

    public static void selectStaff(){
        System.out.print("이름 : ");
        String name = sc.nextLine();
        for(Role r : list){
            if(r.name.equals(name)){
                System.out.println("등록 실패 : 이미 존재하는 이름입니다.");
                return;
            }
        }
        System.out.print("전공 : ");
        String major = sc.nextLine();
        System.out.print("기수 : ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 : ");
        String part = sc.nextLine();
        System.out.print("직책 : ");
        String pos = sc.nextLine();
        list.add(new Staff(2,name,major,num,part,pos));
    }
    public static void main(String[] args){
        while(true){
            System.out.println("======== 멤버 시스템 관리 =======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            int n = sc.nextInt();
            sc.nextLine();
            if(n==4){
                break;
            }
            else if(n==1){
                System.out.println("----멤버 등록----");
                System.out.print("역할 선택(1: 아기사자, 2: 운영진) : ");
                int role = sc.nextInt();
                sc.nextLine();
                if(role==1){
                    selectLion();
                }
                else if(role == 2){
                    selectStaff();
                }
            }
            else if(n==2){
                System.out.println("-- 전체 멤버 목록 --");
                int i=1;
                for(Role r : list){
                    String role;
                    if(r.j==1){
                        role="아기사자";
                    }
                    else{
                        role="운영진";
                    }
                    System.out.println(i+". ["+role+"] "+r.name+" - "+r.num+"기");
                    i++;
                }
                System.out.println("총 "+list.size()+"명");
            }
            else if(n==3){
                System.out.println("-- 이름으로 검색 --");
                System.out.print("검색할 이름 : ");
                String name = sc.nextLine();
                System.out.println("검색 결과");
                for(Role r : list){
                    if(r.name.equals(name)){
                        String role;
                        if(r.j==1){
                            role ="아기사자";
                        }
                        else{
                            role = "운영진";
                        }
                        System.out.println("역할 : "+role);
                        System.out.println(r.getInfo());
                        r.canSubmit();
                    }
                }
            }
        }

    }
}
