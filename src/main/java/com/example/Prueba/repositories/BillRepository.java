package com.example.Prueba.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Prueba.models.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
}
