package com.example.Prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Prueba.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
