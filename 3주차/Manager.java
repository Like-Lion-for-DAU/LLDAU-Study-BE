public class Manager extends Role{
    public String pos;
    public Manager(String name, String major, int num, String part,String pos){
        super(name,major,num,part);
        this.pos = pos;
    }
    @Override
    public submit getPol() {
        return new ManagerCheck();
    }

    @Override
    public String getInfo(){
        return String.format("이름: %s \n전공: %s\n기수: %d\n파트: %s\n직책: %s",
                name, major, num, part, pos);
    }
}