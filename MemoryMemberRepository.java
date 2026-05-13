import java.util.ArrayList;

public class MemoryMemberRepository implements MemberRepository {

    private ArrayList<ArrayList<String>> list = new ArrayList<>();

    @Override
    public void save(ArrayList<String> member) { //save는 인터페이스에서 정의된 메서드이므로, MemoryMemberRepository 클래스에서 구현해야 합니다. 이 메서드는 전달된 member 데이터를 list에 저장하는 역할을 합니다.
        list.add(member);
    }

    @Override
    public ArrayList<ArrayList<String>> findAll() {
        return list;
    }
}