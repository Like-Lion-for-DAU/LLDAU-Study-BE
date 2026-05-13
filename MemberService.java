import java.util.ArrayList;

public class MemberService {

    private MemberRepository repository;

    // 생성자 DI
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public void addMember(String name, String studentId, String part) {

        ArrayList<String> row = new ArrayList<>();

        row.add(name);
        row.add(studentId);
        row.add(part);

        repository.save(row);
    }

    public void printMembersByPart(String part) {

        ArrayList<ArrayList<String>> list = repository.findAll();

        for (ArrayList<String> row : list) {

            if (row.get(2).equals(part)) {
                System.out.println(row);
            }
        }
    }
}