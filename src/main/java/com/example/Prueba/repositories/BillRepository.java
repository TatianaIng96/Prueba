package com.example.Prueba.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Prueba.models.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
