package com.movieapp.demo.Service.Impl;



import com.movieapp.demo.Entity.Member;
import com.movieapp.demo.Entity.Movie;
import com.movieapp.demo.Repository.MemberRepository;
import com.movieapp.demo.Service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements IMemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member saveMember(Member member) {
        if (member.getMovies() != null) {
            for (Movie movie: member.getMovies()) {
                movie.setMember(member); // FK set ediliyor
            }
        }

        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> getMemberById(Long id) {

        return memberRepository.findById(id);
    }

    @Override
    public void deleteMemberById(Long id) {
        if(memberRepository.existsById(id)){ // eger varsa sil
            memberRepository.deleteById(id);
        }
        }

    @Override
    public Optional<Member> updateMember(Long id, Member member) {


            Optional<Member> optional = memberRepository.findById(id);

            if (optional.isEmpty()) {
                return Optional.empty();
            }
            Member dbMember = optional.get();
            dbMember.setUsername(member.getUsername());
            dbMember.setEmail(member.getEmail());
            dbMember.setPassword(member.getPassword());

            Member updated = memberRepository.save(dbMember);
            return Optional.of(updated);
        }






        }


