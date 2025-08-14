package com.example.online_test.config;

import com.example.online_test.migration.online;
import com.example.online_test.migration.status;
import com.example.online_test.repository.onlinerepository;
import com.example.online_test.repository.statusrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class dataseeder implements CommandLineRunner {

    private final onlinerepository onlineRepo;
    private final statusrepository statusRepo;

    public dataseeder(onlinerepository onlineRepo, statusrepository statusRepo) {
        this.onlineRepo = onlineRepo;
        this.statusRepo = statusRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (statusRepo.count() == 0) {
            statusRepo.saveAll(Arrays.asList(
                createStatus(0, "SUCCESS"),
                createStatus(1, "FAILED")
            ));
        }

        if (onlineRepo.count() == 0) {
            List<online> dataList = Arrays.asList(
                createOnline(1372, "10001", "Test 1", 1000, "abc", 0, "2022-07-10 11:14:52", "abc", "2022-07-10 11:14:52", formatter),
                createOnline(1373, "10002", "Test 2", 2000, "abc", 0, "2022-07-11 13:14:52", "abc", "2022-07-10 13:14:52", formatter),
                createOnline(1374, "10001", "Test 1", 1000, "abc", 0, "2022-08-10 12:14:52", "abc", "2022-07-10 12:14:52", formatter),
                createOnline(1375, "10002", "Test 2", 1000, "abc", 1, "2022-08-10 13:10:52", "abc", "2022-07-10 13:10:52", formatter),
                createOnline(1376, "10001", "Test 1", 1000, "abc", 0, "2022-08-10 13:11:52", "abc", "2022-07-10 13:11:52", formatter),
                createOnline(1377, "10002", "Test 2", 2000, "abc", 0, "2022-08-12 13:14:52", "abc", "2022-07-10 13:14:52", formatter),
                createOnline(1378, "10001", "Test 1", 1000, "abc", 0, "2022-08-12 14:11:52", "abc", "2022-07-10 14:11:52", formatter),
                createOnline(1379, "10002", "Test 2", 1000, "abc", 1, "2022-09-13 11:14:52", "abc", "2022-07-10 11:14:52", formatter),
                createOnline(1380, "10001", "Test 1", 1000, "abc", 0, "2022-09-13 13:14:52", "abc", "2022-07-10 13:14:52", formatter),
                createOnline(1381, "10002", "Test 2", 2000, "abc", 0, "2022-09-14 09:11:52", "abc", "2022-07-10 09:11:52", formatter),
                createOnline(1382, "10001", "Test 1", 1000, "abc", 0, "2022-09-14 10:14:52", "abc", "2022-07-10 10:14:52", formatter),
                createOnline(1383, "10002", "Test 2", 1000, "abc", 1, "2022-08-15 13:14:52", "abc", "2022-07-10 13:14:52", formatter)
            );
            onlineRepo.saveAll(dataList);
        }
    }

    private online createOnline(int id, String productID, String productName, int amount, String customerName, int status,
                                String transactionDate, String createBy, String createOn, DateTimeFormatter formatter) {
        online o = new online();
        o.setId(id);
        o.setProductID(productID);
        o.setProductName(productName);
        o.setAmount(amount);
        o.setCustomerName(customerName);
        o.setStatus(status);
        o.setTransactionDate(LocalDateTime.parse(transactionDate, formatter));
        o.setCreateBy(createBy);
        o.setCreateOn(LocalDateTime.parse(createOn, formatter));
        return o;
    }

    private status createStatus(int id, String name) {
        status s = new status();
        s.setId(id);
        s.setName(name);
        return s;
    }
}
