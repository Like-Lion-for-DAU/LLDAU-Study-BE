// Lion.java
package Week2.package1;

public class Lion {
    private String name;
    String major;
    public int generation;

    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    public String getName() { return name; } 

    @Override
    public String toString() {
        return "이름: " + name + " | 전공: " + major + " | 기수: " + generation;
    }
}
