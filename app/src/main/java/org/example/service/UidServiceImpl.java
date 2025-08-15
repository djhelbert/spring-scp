package org.example.service;

import java.util.UUID;

public class UidServiceImpl implements UidService {
    @Override
    public String getUid() {
        return UUID.randomUUID().toString();
    }
}
