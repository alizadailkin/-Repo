package com.movieapp.demo.Service;

import com.movieapp.demo.Entity.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberService {


public List<Member> getAllMembers();
public Member saveMember(Member member);
public Optional<Member> getMemberById(Long id);
public void deleteMemberById(Long id);
public Optional<Member>  updateMember(Long id, Member member);


}
