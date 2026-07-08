import java.util.Scanner; // Scanner 클래스를 사용하기 위해 java.util 패키지에서 가져오기
public class Main { 
    public static void main(String[] args) { // 프로그램 시작 지점 (main 메서드)
        
        Scanner sc = new Scanner(System.in); // 파이썬 input()코드다.

        // 아기사자 수 입력
        int n = sc.nextInt(); // nextInt:정수로 입력 할 수 있게 해준다.
        sc.nextLine(); // vs에 자동완성으로 떠서 넣었습니다. 정수와 문자열 차이는 알겠는데 개행이 헷갈립니다.

        String[] names = new String[n]; // 입력받은 수만큼 문자열 배열 생성

        int i = 0; // 반복문에서 사용할 인덱스 변수 0으로

        // while문으로 이름 입력 받기
        while (i < n) { // i가 n보다 작은 동안 반복 (n번 반복)
            System.out.print((i + 1) + "번째 이름 입력: "); // 몇 번째 입력인지 안내
            names[i] = sc.nextLine(); //nextLine을 쓰면 한줄 전체를 입력받고 next를 쓰면 개행이 사라진다.
            i++; // 인덱스 1 증가 (다음 입력을 위해)
        }

        // 결과 출력
        System.out.println("\n=== 아기사자 명단 ==="); // 줄바꿈 후 제목 출력

        i = 0; //반복을 위해 i 다시 0으로 바꾸기
        while (i < n) { // i가 n보다 작은 동안 반복
            System.out.println((i + 1) + ". " + names[i]); //index값으로 지정된 배열에서 하나씩 문자열을 불러옴
            i++; // 인덱스 증가
        }

        sc.close(); // 이거 왜하나요? Scanner 객체를 닫아서 자원을 해제하기 위해서입니다. Scanner는 시스템 자원을 사용하므로 사용이 끝나면 닫아주는 것이 좋습니다.
    }
}