package com.gmit.erp.service;

import com.gmit.erp.repository.MemberRepository;
import com.gmit.erp.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<MemberVo> findAll(){
        List<MemberVo> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public Optional<MemberVo> findById(Long no){
        Optional<MemberVo> member = memberRepository.findById(no);
        return member;
    }

    public Optional<MemberVo> findById(String id) {
        Optional<MemberVo> member = memberRepository.findById(id);
        return member;
    }

    public Optional<MemberVo> findByEmail(String email){
        Optional<MemberVo> member = memberRepository.findByEmail(email);
        return member;
    }

    public void deleteById(Long no) {
        memberRepository.deleteById(no);
    }

    public MemberVo save(MemberVo member) {
        memberRepository.save(member);
        return member;
    }

    public void updateById(Long no, MemberVo member) {
        Optional<MemberVo> e = memberRepository.findById(no);

        if (e.isPresent()) {
            e.get().setNo(member.getNo());
            e.get().setId(member.getId());
            e.get().setName(member.getName());
            memberRepository.save(member);
        }
    }


}
