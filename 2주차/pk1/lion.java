package pk1;

public class lion {
    public String name;
    String major;
    private int num;

    public lion(String name, String major, int num){
        this.name = name;
        this.major = major;
        this.num = num;
        
    }

    public void p(){
        System.out.printf("이름 : %s | 전공 : %s | 기수 : %d",name,major,num);
    }

    public void check(String name, String major, int num){
        if(name.isEmpty()){
            System.out.println("이름은 비어있을 수 없습니다.");
            System.out.println("잘못된 아기사자 정보입니다.");

        }
        else if(major.isEmpty()){
            System.out.println("전공은 비어있을 수 없습니다.");
            System.out.println("잘못된 아기사자 정보입니다.");

        }
        else if(num<1){
            System.out.println("기수는 1이상이어야 합니다.");
            System.out.println("잘못된 아기사자 정보입니다.");
        
        }
        else{
            System.out.println("아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            System.out.println("아기사자 정보를 출력합니다.");
            p();
            
        }
    }
}
