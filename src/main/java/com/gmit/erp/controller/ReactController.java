package com.gmit.erp.controller;

import com.gmit.erp.service.MemberService;
import com.gmit.erp.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ReactController {

    @Autowired
    MemberService memberService;

    @GetMapping("/hello")
    public String test(){
        return "HELLO, WORLD! ";
    }

//    @GetMapping("/MemberTest")
//    public String GetMember(){
//        return "";
//
//    }

    // 이메일로 회원 조회
    @GetMapping(value = "/MemberTest/{email}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<MemberVo> getMember(@PathVariable("email") String email){
        Optional<MemberVo> member = memberService.findByEmail(email);
        return new ResponseEntity<MemberVo>(member.get(), HttpStatus.OK);
    }


    // 모든 회원 조회
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<MemberVo>> getAllMembers(){
        List<MemberVo> member = memberService.findAll();
        return new ResponseEntity<List<MemberVo>>(member, HttpStatus.OK);
    }


}
