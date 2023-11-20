package com.dci.demo.repository;


import com.dci.demo.domain.model.Recinto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecintoRepository extends JpaRepository<Long, Recinto> {


    List<Recinto> findByRecTipos(Long tipId);


}
