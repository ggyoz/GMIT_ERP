package com.gmit.erp.mapper;

import java.util.List;

import com.gmit.erp.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    List<TestVo> selectTest();
}