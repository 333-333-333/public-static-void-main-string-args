package com.dci.demo.repository;


import com.dci.demo.domain.Recinto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Repository
public interface RecintoRepository extends JpaRepository<Recinto, Long> {


}
