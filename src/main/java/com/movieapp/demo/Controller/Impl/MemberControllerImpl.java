package com.movieapp.demo.Controller.Impl;

import com.movieapp.demo.Controller.IMemberController;
import com.movieapp.demo.Entity.Member;
import com.movieapp.demo.Service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/rest/api/member")
public class MemberControllerImpl implements IMemberController {

    @Autowired
    private IMemberService memberService;



    @GetMapping(path = "/list")
    @Override
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping("/save")
    @Override
    public Member saveMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }

    @GetMapping("/{id}")
    @Override
    public Optional<Member> getMemberById(@PathVariable (name = "id") Long id) {
        return memberService.getMemberById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteMemberById(@PathVariable(name = "id") Long id) {
        memberService.deleteMemberById(id);

    }

    @PutMapping("/update/{id}")
    @Override
    public Optional<Member> updateMember(@PathVariable(name = "id") Long id, @RequestBody Member member) {
        return memberService.updateMember(id,member);
    }


}

