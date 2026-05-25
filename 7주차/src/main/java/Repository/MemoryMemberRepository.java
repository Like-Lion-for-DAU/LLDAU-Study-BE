package Repository;

import Role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    public final ArrayList<Role> members = new ArrayList<Role>();

    @Override
    public ArrayList<Role> findAll(){
        return new ArrayList<Role>(members);
    }

    @Override
    public void save(Role member){
        members.add(member);
    }

    @Override
    public Role findByName(String name) {
        for(Role m : members){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    @Override
    public void updateByName(String name, Role member) {
        for(int i=0 ; i<members.size(); i++){
            if(members.get(i).getName().equals(name)){
                members.set(i,member);
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return members.removeIf(member -> member.getName().equals(name));
    }

    @Override
    public boolean existsByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
