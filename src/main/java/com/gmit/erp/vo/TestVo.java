package com.gmit.erp.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class TestVo {

    private Long mbrNo;
    @NonNull
    private String id;
    @NonNull
    private String name;

    //public TestVo(String id, String name){}

}

