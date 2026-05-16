package com.example.demo.role;

import com.example.demo.policy.StaffCheck;
import com.example.demo.policy.submit;
import com.example.demo.role.Role;


public class Staff extends Role {
    public String pos;
    public Staff(int j,String name, String major, int num, String part,String pos){
        super(j,name,major,num,part);
        this.pos = pos;
    }
    @Override
    public submit getPol() {
        return new StaffCheck();
    }

    @Override
    public String getInfo(){
        return String.format("이름: %s \n전공: %s\n기수: %d\n파트: %s\n직책: %s",
                name, major, num, part, pos);
    }
}