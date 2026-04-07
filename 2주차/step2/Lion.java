package step2;

public class Lion {
    public String name;
    String major; // default는 자동이라 명시 불가.
    private Integer year;

    public Lion(String name, String major, Integer year) {
        if(name.isEmpty() || major.isEmpty() || year < 1) {
            System.out.println("오류: 답변이 이상함. 아기사자가 될 자격 없음.");
            return;
        }

        this.name = name;
        this.major = major;
        this.year = year;

        System.out.println("환영한다. " + year + "기 " +  major + " " + name);
    }
}