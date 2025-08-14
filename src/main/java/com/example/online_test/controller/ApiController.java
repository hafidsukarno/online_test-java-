package com.example.online_test.controller;

import com.example.online_test.migration.online;
import com.example.online_test.migration.status;
import com.example.online_test.repository.onlinerepository;
import com.example.online_test.repository.statusrepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    private final onlinerepository onlinerepository;
    private final statusrepository statusrepository;

    public ApiController(onlinerepository onlinerepository, statusrepository statusrepository) {
        this.onlinerepository = onlinerepository;
        this.statusrepository = statusrepository;
    }

    @GetMapping("/viewdata")
    public Map<String, Object> getViewData() {
        Map<String, Object> response = new HashMap<>();

        List<online> data = onlinerepository.findAll();
        List<status> status = statusrepository.findAll();

        // Masukkan ke response JSON
        response.put("data", data);
        response.put("status", status);

        return response;
    }
}
