package org.example.service;

import jakarta.annotation.PreDestroy;

import java.util.UUID;

public class UidServiceImpl implements UidService {
    @Override
    public String getUid() {
        return UUID.randomUUID().toString();
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("warning: UidServiceImpl is about to be destroyed");
    }
}
