package com.example.balo_center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Security;

@SpringBootApplication
public class BaloCenterApplication {

    public static void main(String[] args) {
        Security.setProperty("jdk.certpath.disabledAlgorithms", "MD2, MD5, RSA keySize < 1024");
        SpringApplication.run(BaloCenterApplication.class, args);
    }

}
