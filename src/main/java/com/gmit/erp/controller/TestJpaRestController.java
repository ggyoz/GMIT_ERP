package com.gmit.erp.controller;

import com.gmit.erp.service.MemberService;
import com.gmit.erp.vo.MemberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("memberTest")
public class TestJpaRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberService memberService;

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{no}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MemberVo> getMember(@PathVariable("no") Long no){
        Optional<MemberVo> member = memberService.findById(no);
        return new ResponseEntity<MemberVo>(member.get(), HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{no}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("no") Long no) {
        memberService.deleteById(no);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원번호로 회원 수정(no로 회원을 찾아 Member 객체의 id, name로 수정함)
    @PutMapping(value = "/{no}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MemberVo> updateMember(@PathVariable("no") Long no, MemberVo member) {
        memberService.updateById(no, member);
        return new ResponseEntity<MemberVo>(member, HttpStatus.OK);
    }

    // 회원 입력
    @PostMapping
    public ResponseEntity<MemberVo> save(MemberVo member) {
        return new ResponseEntity<MemberVo>(memberService.save(member), HttpStatus.OK);
    }

    // 회원 입력
    @RequestMapping(value="/saveMember", method = RequestMethod.GET)
    public ResponseEntity<MemberVo> save(HttpServletRequest req, MemberVo member){
        return new ResponseEntity<MemberVo>(memberService.save(member), HttpStatus.OK);
    }

}
