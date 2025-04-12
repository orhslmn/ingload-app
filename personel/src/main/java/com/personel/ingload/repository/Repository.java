package com.personel.ingload.repository;

import com.personel.ingload.model.Ignload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<Ignload, Long> {


    @Query("SELECT i FROM Ignload i ORDER BY random()")
    List<Ignload> findRandomKelimeler(Pageable pageable);
}
