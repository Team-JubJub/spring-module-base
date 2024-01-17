package com.zupzup.untact.api;

import com.zupzup.untact.model.BaseEntity;
import com.zupzup.untact.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
@ResponseBody
@RequiredArgsConstructor
public class BaseControllerImpl<E extends BaseEntity, Rq, Rs, R extends JpaRepository<E, Long>> implements BaseController<Rq, Rs> {

    private final BaseService<E, Rq, Rs, R> baseService;

    @Override
    @PostMapping
    public ResponseEntity<Rs> save(Rq request) {

        Rs rs = baseService.save(request);
        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<Object> findAll() {

        List<Rs> rsList = baseService.findAll();
        return new ResponseEntity<>(rsList, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Rs> find(@PathVariable Long id) {

        Rs res = baseService.find(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Rs> update(@PathVariable Long id, @RequestBody Rq request) {

        Rs rs = baseService.update(id, request);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @Override
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {

        Long rs = baseService.delete(id);
        return null;
    }
}
