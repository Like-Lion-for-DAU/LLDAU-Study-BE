package Controller;

import Role.Lion;
import Role.Role;
import Role.Staff;
import Service.MemberService;
import dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<Object>> getAllMember(){
        ArrayList<Object> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @PostMapping("/lions")
    public ResponseEntity<?> createLion(@RequestBody LionCreateRequest request){
        Lion lion = memberService.createLion(request);
        if(lion == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<?> createStaff(@RequestBody StaffCreateRequest request){
        Staff staff = memberService.createStaff(request);
        if(staff == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from(staff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable("name") String name){
        Role member = memberService.getMember(name);
        if(member == null){
            return ResponseEntity.notFound().build();
        }
        if(member instanceof Lion){
            return ResponseEntity.ok(LionResponse.from((Lion) member));
        }
        else if(member instanceof Staff){
            return ResponseEntity.ok(StaffResponse.from((Staff) member));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<?> updateLion(@PathVariable("name") String name, @RequestBody LionUpdateRequest request){
        Lion lion = memberService.updateLion(name, request);
        if(lion == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LionResponse.from(lion));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<?> updateStaff(@PathVariable("name") String name, @RequestBody StaffUpdateRequest request){
        Staff staff = memberService.updateStaff(name, request);
        if(staff == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StaffResponse.from(staff));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteMember(@PathVariable("name") String name){
        boolean isDeleted = memberService.deleteMember(name);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
