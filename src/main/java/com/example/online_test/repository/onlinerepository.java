package com.example.online_test.repository;

import com.example.online_test.migration.online;
import org.springframework.data.jpa.repository.JpaRepository;

public interface onlinerepository extends JpaRepository<online, Integer> {
}