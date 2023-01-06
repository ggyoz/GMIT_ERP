package com.gmit.erp.service;

import com.gmit.erp.config.SecurityUtil;
import com.gmit.erp.dto.MemberResponseDto;
import com.gmit.erp.entity.Member;
import com.gmit.erp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResponseDto getMyInfoBySecurity() {
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }

    @Transactional
    public MemberResponseDto changeMemberNickname(String email, String nickname) {
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        member.setNickname(nickname);
        return MemberResponseDto.of(memberRepository.save(member));
    }

    @Transactional
    public MemberResponseDto changeMemberPassword(String exPassword, String newPassword) {
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        if (!passwordEncoder.matches(exPassword, member.getPassword())) {
            throw new RuntimeException("비밀번호가 맞지 않습니다.");
        }
        member.setPassword(passwordEncoder.encode((newPassword)));
        return MemberResponseDto.of(memberRepository.save(member));
    }

    /*public List<MemberVo> findAll(){
        List<MemberVo> members = new ArrayList<>();
        memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }

    public Optional<MemberVo> findById(Long no){
        Optional<MemberVo> member = memberRepository.findById(no);
        return member;
    }*/

    /*public Optional<MemberVo> findById(String id) {
        Optional<MemberVo> member = memberRepository.findById(id);
        return member;
    }*/

/*    public Optional<MemberVo> findByEmail(String email){
        Optional<MemberVo> member = memberRepository.findByEmail(email);
        return member;
    }*/

    /*public void deleteById(Long no) {
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
*/
}