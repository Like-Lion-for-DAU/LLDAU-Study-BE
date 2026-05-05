import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner; // 사용자에게 값을 입력받기 위해 Scanner 기능을 가져옴

public class Week4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 키보드 입력을 받기
        System.out.print("멤버의 수는? ");
        int j = sc.nextInt();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> member = new ArrayList<>();
        for (int i = 0; i < j ; i++) {
            System.out.print("이름을 입력하세요: ");
            String name = sc.nextLine();
            System.out.print("학번을 입력하세요: ");
            String studentId = sc.nextLine();
            System.out.print("파트를 입력하세요: ");
            String part = sc.nextLine();
            member.add(name);
            member.add(studentId);
            member.add(part);
            list.add(member);
            System.out.println(list);
            //멤버 수만큼 리스트를 만들어서 넣을 수 있게 해야하는데 못하겠습니다.
           //member값 list에 저장시키고 비워도 list에 저장된 값이 사라지는 문제가 있습니다. 어떻게 해야할까요? 
        
    }
        System.out.print("파트를 입력하세요: ");
        String part = sc.nextLine();
        if (list.contains(part)) {
            System.out.println(member);
        } 
    HashMap map = new HashMap<>();
    if (list.contains("백엔드")) {
        map.put("백엔드", member);

}
}
}
//member들 개수만 어떻게 좀 자동적으로 늘릴 수 없을까요