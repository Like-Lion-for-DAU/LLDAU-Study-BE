package pk1;

import java.util.Scanner;

//보너스 문제
public class b_step {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("아기사자 이름을 입력해주세요: ");
        String name = scanner.nextLine();
        System.out.print("전공을 입력해주세요: ");
        String major = scanner.nextLine();
        System.out.print("기수를 입력해주세요: ");
        int num = scanner.nextInt();

        scanner.nextLine();
        
        b_lion l = new b_lion(name,major,num);
        System.out.println("\n===================");
        while(true){
            System.out.println("아기사자 정보를 수정하시겠습니까?(네/아니요)");
            String tmp = scanner.nextLine();
            if(tmp.equals("네")){
                System.out.print("수정할 정보를 입력해주세요.(이름 / 전공 / 기수)\n");
                String info = scanner.nextLine();
                System.out.printf("변경할 %s를 입력해주세요\n",info);
                String ch = scanner.nextLine();
                if(info.equals("이름")){
                    l.name=ch;
                }
                else if(info.equals("전공")){
                    l.major=ch;
                }
                else if(info.equals("기수")){
                    int a = Integer.parseInt(ch);
                    l.num=a;
                }
                System.out.printf("%s 변경 요청을 받았습니다.\n",info);
                System.out.printf("%s이 정상적으로 변경되었습니다..\n",info);
                l.p();

            }
            else{
                System.out.println("아기사자 정보 수정을 종료합니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}