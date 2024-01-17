package com.zupzup.untact.service;


import com.zupzup.untact.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseService<E extends BaseEntity, Rq, Rs, R extends JpaRepository<E, Long>> {

    List<Rs> findAll(); // 전체 찾기
    Rs find(Long id); // 단건 찾기
    Rs save(Rq rq); // 저장
    Rs update(Long id, Rq rq); // 업데이트
    Long delete(Long id); // 삭제
}
