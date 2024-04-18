package th.ac.utcc.kradadtodapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
