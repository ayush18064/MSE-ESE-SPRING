package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MSE;

@Repository
public interface MSERepo extends JpaRepository<MSE, Integer> {

}
