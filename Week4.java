import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Week4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 키보드 입력을 받기
        System.out.print("멤버의 수는? ");
        int j = sc.nextInt();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for (int i = 0; i < j ; i++) {
            ArrayList<String> Row = new ArrayList<>(); // 멤버 리스트 초기화
            
                sc.nextLine(); // 버퍼 비우기
                System.out.print("이름을 입력하세요: ");
                String name = sc.nextLine();

                System.out.print("학번을 입력하세요: ");
                String studentId = sc.nextLine();


                
                System.out.print("파트를 입력하세요: ");
                String part = sc.nextLine();
            Row.add(name);
            Row.add(studentId);

            Row.add(part);
            
        list.add(Row);
        
    }
            System.out.println(list);

        System.out.print("파트를 입력하세요: ");
        String part = sc.nextLine();
        if (list.contains(part)) {
            //System.out.println(list);
        
    HashMap map = new HashMap<>();
   
        for (ArrayList<String> Row : list) {
            String partKey = Row.get(2); // 파트 정보는 Row의 2번째 요소에 저장되어 있다고 가정
           map.put(partKey, Row); // 파트를 키로, 전체 Row를 값으로 저장
            }
        
        System.out.println(map.get("백엔드"));
        for (String Key : map.keySet()) {//왜 오류가 나나요
    System.out.println("키(이름): " + Key + " / 값(데이터): " + map.get(Key));
        }
    }
}
}
//


//이중for문 했다가 바꿔서 그냥 ArrayList<ArrayList<String>> list = new ArrayList<>(); 하니까 됩니다. 왜 되나요?