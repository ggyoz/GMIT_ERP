package com.gmit.erp.vo;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class MemberVoTest {

    @Test
    public void getId() {
        final MemberVo memberVo = MemberVo.builder().id("ggyoz").name("허진욱").build();
        final String id = memberVo.getId();
        assertEquals("ggyoz", id);
    }

    @Test
    public void getName(){
        final MemberVo memberVo = MemberVo.builder().id("ggyoz").name("허진욱").build();
        final String name = memberVo.getName();
        assertEquals("진욱", name);
    }
}