package Service;

import Repository.MemberRepository;
import Role.Staff;
import Role.Lion;
import Role.Role;
import dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public ArrayList<Object> getAllMembers(){
        ArrayList<Role> roleList =  memberRepository.findAll();
        ArrayList<Object> allList = new ArrayList<>();

        for(Role r : roleList){
            if(r instanceof Lion){
                allList.add(LionResponse.from((Lion) r));
            }
            else if(r instanceof Staff){
                allList.add(StaffResponse.from((Staff) r));
            }
        }
        return allList;
    }

    public Role getMember(String name){
        return memberRepository.findByName(name);
    }

    public Lion createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }

        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        memberRepository.save(lion);
        return lion;
    }

    public Staff createStaff(StaffCreateRequest request){
        if(memberRepository.existsByName(request.getName())){
            return null;
        }

        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
                );
        memberRepository.save(staff);
        return staff;

    }

    public Lion updateLion(String name, LionUpdateRequest request) {
        Role member = memberRepository.findByName(name);
        if (!(member instanceof Lion)) {
            return null;
        }
        Lion lion = (Lion) member;
        lion.update(
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );
        memberRepository.updateByName(name, lion);
        return lion;
    }
    public Staff updateStaff(String name, StaffUpdateRequest request) {
        Role member = memberRepository.findByName(name);
        if (!(member instanceof Staff)) {
            return null;
        }
        Staff staff = (Staff) member;
        staff.update(
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );
        memberRepository.updateByName(name, staff);
        return staff;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}
