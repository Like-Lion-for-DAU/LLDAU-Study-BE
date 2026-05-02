package role;

import policy.LionCheck;
import policy.submit;

public class Lion extends Role{
    public int index;

    public Lion(int j, String name, String major, int num, String part, int index){
        super(j,name,major,num,part);
        this.index = index;
    }
    @Override
    public submit getPol() {
        return new LionCheck();
    }

    @Override
    public String getInfo(){
        return String.format("이름: %s \n전공: %s\n기수: %d\n파트: %s\n학번: %s",
                name, major, num, part, index);
    }
}
