package pk1;

//보너스 문제
public class b_lion {
    public String name;
    String major;
    public int num;

    public b_lion(String name, String major, int num){
        if(name.isEmpty()){
            System.out.println("이름은 비어있을 수 없습니다.");

        }
        else if(major.isEmpty()){
            System.out.println("전공은 비어있을 수 없습니다.");

        }
        else if(num<1){
            System.out.println("기수는 1이상이어야 합니다.");
        
        }
        else{
            System.out.println("유효한 값으로 아기사자 객체가 생성되었습니다.");
            this.name = name;
            this.major = major;
            this.num = num; 
            p();
            
        }
        
    }

    public void p(){
        System.out.printf("이름 : %s | 전공 : %s | 기수 : %d\n",name,major,num);
    }

    
}
