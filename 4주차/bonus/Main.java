package bonus;

import role.Lion;
import role.Role;
import role.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Role> list = new ArrayList<Role>();
    static HashMap<String, ArrayList<Role>> map = new HashMap<String, ArrayList<Role>>();

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
        Lion lion = new Lion(1,name,major,num,part,index);
        list.add(lion);

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
        Staff staff = new Staff(2,name,major,num,part,pos);
        list.add(staff);

    }
    public static void main(String[] args){
        while(true){
            System.out.println("======== 멤버 시스템 관리 =======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 멤버 삭제");
            System.out.println("6. 기수순 정렬 조회");
            System.out.println("7. 파트별 통계 조회");
            System.out.println("8. 종료");
            System.out.print("선택: ");
            int n = sc.nextInt();
            sc.nextLine();
            if(n==8){
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
            else if(n==4){
                int i=1;
                map.put("백엔드", new ArrayList<Role>());
                map.put("프론트엔드", new ArrayList<Role>());
                for(Role r : list){
                    if(r.part.equals("백엔드")){
                        map.get("백엔드").add(r);
                    }else{
                        map.get("프론트엔드").add(r);
                    }
                }
                System.out.println("-- 파트별 조회 --");
                System.out.println("등록된 파트 : [백엔드, 프론트엔드]");
                System.out.print("조회할 파트 : ");
                String part = sc.nextLine();
                if(part.equals("백엔드")){
                    System.out.println("백엔드 파트 멤버");
                    for(Role r : map.get("백엔드")){
                        String role;
                        if(r.j==1){
                            role = "아기사자";
                        }
                        else{
                            role = "운영진";
                        }
                        System.out.println(i+". "+r.name+"("+role+")"+" - "+ r.num+"기");
                        i++;
                    }
                }
                else if(part.equals("프론트엔드")){
                    System.out.println("프론트엔드 파트 멤버");
                    for(Role r : map.get("프론트엔드")){
                        String role;
                        if(r.j==1){
                            role = "아기사자";
                        }
                        else{
                            role = "운영진";
                        }
                        System.out.println(i+". "+r.name+"("+role+")"+" - "+ r.num+"기");
                        i++;
                    }
                }
            }
            // 삭제
            else if(n==5){
                System.out.println("-- 멤버 삭제 --");
                System.out.print("삭제할 이름 : ");
                String deleteName = sc.nextLine();

                java.util.Iterator<Role> it;
                it = list.iterator();
                while(it.hasNext()){
                    Role r = it.next();
                        if(r.name.equals(deleteName)){
                            String part = r.part;

                            it.remove();

                            if (map.containsKey(part)) {
                                ArrayList<Role> partList = map.get(part);
                                for (int j = 0; j < partList.size(); j++) {
                                    if (partList.get(j).name.equals(deleteName)) {
                                        partList.remove(j);
                                        break;
                                    }
                                }
                            }
                            System.out.println(deleteName + " 멤버가 정상적으로 삭제되었습니다.");
                        }

                }

            }
            else if(n==6){
                System.out.println("-- 기수 순 정렬 조회 --");

                ArrayList<Role> sortedList = new ArrayList<Role>(list);
                sortedList.sort((r1, r2) -> Integer.compare(r1.num, r2.num));
                int i=1;
                for(Role r : sortedList){
                    String part;
                    if(r.j==1){
                        part = "아기사자";
                    }
                    else{
                        part = "운영진";
                    }
                    System.out.println(i+". ["+r.num+"기] "+r.name+ "("+part+")");
                }
            }
            else if(n==7){
                System.out.println("-- 파트별 통계 --");
                HashMap<String, Integer> statisMap = new HashMap<String, Integer>();
                for(Role r : list){
                    statisMap.put(r.part,statisMap.getOrDefault(r.part,0)+1);
                }
                for(String partName: statisMap.keySet()){
                    System.out.println(partName+": "+statisMap.get(partName)+"명");
                }
                System.out.println("총 멤버: "+list.size()+"명");

            }
        }

    }
}
