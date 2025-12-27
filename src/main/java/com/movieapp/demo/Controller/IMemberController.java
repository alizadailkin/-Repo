package com.movieapp.demo.Controller;

import com.movieapp.demo.Entity.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberController {

    public List<Member> getAllMembers();

    public Member saveMember(Member member);

    public Optional<Member> getMemberById(Long id);

    public void deleteMemberById(Long id);

    public Optional<Member> updateMember(Long id, Member member);
}




