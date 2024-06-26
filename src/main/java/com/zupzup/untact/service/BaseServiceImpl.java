package com.zupzup.untact.service;

import com.zupzup.untact.model.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BaseServiceImpl<E extends BaseEntity, Rq, Rs, R extends JpaRepository<E, Long>> implements BaseService<E, Rq, Rs, R> {

    private final R repository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Rs> findAll() {

        List<E> eList = repository.findAll();
        List<Rs> RsList = new ArrayList<>();

        for(E e : eList) {
            Rs rs = modelMapper.map(e, getResponseType());
            RsList.add(rs);
        }

        return RsList;
    }

    @Override
    public Rs find(Long id) {

        E e = repository.findById(id).orElseThrow(() -> new RuntimeException("찾을 수 없는 사용자입니다."));

        return modelMapper.map(e, getResponseType());
    }

    @Override
    @Transactional
    public Rs save(Rq rq) {

        E e = modelMapper.map(rq, getEntityType());
        repository.save(e);

        return modelMapper.map(e, getResponseType());
    }

    @Override
    @Transactional
    public Rs update(Long id, Rq rq) {
        // 각각의 서비스에서 implement 해서 구현
        return null;
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        E e = repository.findById(id).get();
        e.setDeleted(true);
        return id;
    }

    // Helper method to get the entity type
    private Class<E> getEntityType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) parameterizedType.getActualTypeArguments()[0];
    }

    // Helper method to get the response type
    private Class<Rs> getResponseType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<Rs>) parameterizedType.getActualTypeArguments()[2];
    }
}
