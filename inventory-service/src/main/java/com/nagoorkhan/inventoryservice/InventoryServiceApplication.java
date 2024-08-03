package com.nagoorkhan.inventoryservice;

import com.nagoorkhan.inventoryservice.model.InventoryVO;
import com.nagoorkhan.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);

    }

    @Bean
    public CommandLineRunner loadProducts(InventoryRepository inventoryRepository) {
        return args -> {
            InventoryVO inventoryVO = new InventoryVO("Iphone 15", 3L);
            InventoryVO inventoryVO1 = new InventoryVO("Iphone 15 Black", 5L);
            InventoryVO inventoryVO2 = new InventoryVO("Iphone 16 Max Pro", 0L);
            inventoryRepository.save(inventoryVO);
            inventoryRepository.save(inventoryVO1);
            inventoryRepository.save(inventoryVO2);
        };
    }

}
