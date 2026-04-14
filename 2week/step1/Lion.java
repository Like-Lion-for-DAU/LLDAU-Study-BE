package step1;

public class Lion {
    public String name;
    String major; // default는 자동이라 명시 불가.
    private Integer year;

    public Lion(String name, String major, Integer year) {
        this.name = name;
        this.major = major;
        this.year = year;
    }
}