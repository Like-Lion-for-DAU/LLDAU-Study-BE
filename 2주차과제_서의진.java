public class main{ 
    void main(string[] args)
    Lion lion = new LIon();
    lion.name = "서의진" 
   lion.class_of(26);
    lion.major("Ai학과");
    System.out.println("이름:"lion.name);
    System.out.println("학번:"lion.class_of);
    System.out.println("학과:"lion.major);

class Lion{
    String name;
    private int class_of;
    private String major;

    public void class_of(int class_of){
        this.class_of = class_of;
        System.out.println("학번은 10보다 커야합니다.");

        }
    public void major(String major){
        this.major = major;
        System.out.println();
    }
    public int getClass_of(){
        return class_of; 
    }
    public String getMajor(){ //문저열 반환에 대해 자세히 알고 싶어요      return major;
    }
}