import java.util.ArrayList;

public class MockMemberRepository implements MemberRepository {

    @Override
    public void save(ArrayList<String> member) {
        System.out.println("Mock 저장 완료");
    }

    @Override
    public ArrayList<ArrayList<String>> findAll() { //목에 넣어줌 메서드findAll()는 인터페이스에서 정의된 메서드이므로, MockMemberRepository 클래스에서 구현해야 합니다. 이 메서드는 실제로 데이터를 저장하거나 조회하는 대신, 테스트를 위해 미리 정의된 데이터를 반환하도록 구현

        ArrayList<ArrayList<String>> mockList = new ArrayList<>();

        ArrayList<String> row1 = new ArrayList<>();
        row1.add("서의진"); //테스트용
        row1.add("2654064");
        row1.add("백엔드");

        ArrayList<String> row2 = new ArrayList<>();
        row2.add("김주완"); //테스트용
        row2.add("2654063");
        row2.add("프론트엔드");

        mockList.add(row1);
        mockList.add(row2);

        return mockList;
    }
}