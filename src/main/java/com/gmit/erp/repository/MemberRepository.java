package com.gmit.erp.repository;

import com.gmit.erp.vo.MemberVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberVo, Long> {

    public Optional<MemberVo> findById(String id);

    public Optional<MemberVo> findByName(String name);

    public Optional<MemberVo> findByEmail(String email);

    public List<MemberVo> findByNameLike(String keyword);

}
