package com.dci.demo.repository;

import com.dci.demo.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r WHERE r.resRecinto.recId = :rec_Id")
    List<Reserva> findReservasByRecinto(@Param("rec_Id") Long recId);

    // Reservas por recinto y desde el dia y hora en cuestión en adelante.
    @Query("SELECT r FROM Reserva r WHERE r.resRecinto.recId = :rec_Id AND r.resInicio >= :res_Inicio")
    List<Reserva> findReservasByRecintoAndInicio(@Param("rec_Id") Long recId, @Param("res_Inicio") LocalDateTime resInicio);


}
