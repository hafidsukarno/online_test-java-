package com.example.online_test.repository;

import com.example.online_test.migration.status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface statusrepository extends JpaRepository<status, Integer> {
}