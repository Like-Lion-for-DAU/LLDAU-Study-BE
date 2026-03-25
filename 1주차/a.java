import java.util.Scanner;

public class a{
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("저장할 아기 사자 수를 5 이상 입력해주세요.");
            n = Integer.parseInt(in.nextLine());
            if(n>=5) break;  
            System.out.println("[오류] 5 이상 입력해주세요.");        

        }
        String[] arr = new String[n];

        System.out.println("아기사자 이름을 입력해주세요."); 

        for(int i=0 ; i<n ; i++){
            arr[i] = in.nextLine();
        }

        System.out.println("아기사자 명단을 최종적으로 출력합니다."); 

        for(int i=0 ; i<n ; i++){
            System.out.println(i+1 + ". " + arr[i]); 
        }
        
        
    }
}