package th.ac.utcc.kradadtodapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.utcc.kradadtodapi.dataTransfer.UserData;
import th.ac.utcc.kradadtodapi.models.Member;
import th.ac.utcc.kradadtodapi.repositories.MemberRepository;

import java.util.List;

@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/getMember")
    List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    @GetMapping("/auth")
    public ResponseEntity<UserData> getAuth(@RequestParam String identity, @RequestParam String password) {
        List<Member> emailIdentity = memberRepository.findAllByEmailEqualsAndPassword(identity, password);
        List<Member> usernameIdentity = memberRepository.findAllByUsernameEqualsAndPassword(identity, password);

        UserData userData = new UserData();

        if (emailIdentity.size() == 1) {
            userData.setId(emailIdentity.get(0).getId());
            userData.setUsername(emailIdentity.get(0).getUsername());
            userData.setEmail(emailIdentity.get(0).getEmail());
            userData.setDisplayName(emailIdentity.get(0).getDisplayName());
            return new ResponseEntity<>(userData, HttpStatus.OK);
        } else if (usernameIdentity.size() == 1) {
            userData.setId(usernameIdentity.get(0).getId());
            userData.setUsername(usernameIdentity.get(0).getUsername());
            userData.setEmail(usernameIdentity.get(0).getEmail());
            userData.setDisplayName(usernameIdentity.get(0).getDisplayName());
            return new ResponseEntity<>(userData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userData, HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/user")
    public ResponseEntity<Member> updateUserData(@RequestBody UserData data) throws Exception {
        Member memberData = memberRepository.findByUsername(data.getUsername())
                .orElseThrow(() -> new Exception("Member not found with id: " + data.getUsername()));

        if (data.getDisplayName() != null) {
            memberData.setDisplayName(data.getDisplayName());
        }

        if (data.getEmail() != null) {
            memberData.setEmail(data.getEmail());
        }

        return new ResponseEntity<>(memberRepository.save(memberData), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Member> postUserData(@RequestBody Member member) {
        Member memberData = new Member();

        memberData.setUsername(member.getUsername());
        memberData.setEmail(member.getEmail());
        memberData.setDisplayName(member.getDisplayName());
        memberData.setProfileUrl(member.getProfileUrl());
        memberData.setPassword(member.getPassword());

        return new ResponseEntity<>(memberRepository.save(memberData), HttpStatus.OK);
    }
}
