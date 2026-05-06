package class4.role;

import class4.policy.policyinter;

public abstract class wlq {
    public String name;
    public String major;
    public int generation;
    public String part;

    public wlq(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public abstract policyinter getPolicy();

    public abstract String getInfo();

    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    public void printInfo() {
        System.out.println(name + " - " + generation + "기");
    }
}