package com.gmit.erp.vo;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="TB_MEMBER") // @Entity가 붙은 클래스는 JPA가 관리하는 클래스이고, 테이블과 매핑할 테이블은 해당 어노테이션을 붙인다.
public class MemberVo {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 설정 컬럼 //GenerationType.IDENTITY는 기본 키 생성을 데이터베이스에 위임하는 방식이다.
    private Long no;

    private String id;

    private String name;

    private String email;

    private String password;

    @Builder
    public MemberVo(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}