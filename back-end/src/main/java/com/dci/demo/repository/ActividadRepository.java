package com.dci.demo.repository;

import com.dci.demo.domain.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {


    @Query("SELECT r.recActividades FROM Recinto r WHERE r.recId = :recId")
    List<Actividad> findActividadesByRecinto(@Param("recId") Long recId);

}
