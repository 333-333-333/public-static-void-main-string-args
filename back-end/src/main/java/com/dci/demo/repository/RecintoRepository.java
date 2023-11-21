package com.dci.demo.repository;


import com.dci.demo.domain.Recinto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecintoRepository extends JpaRepository<Recinto, Long> {


    List<Recinto> findByRecTipos(Long tipId);


}
