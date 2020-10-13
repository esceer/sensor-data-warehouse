package com.esceer.sdw.service.identifier;

import java.util.UUID;

public final class UuidFactoryImpl implements IdFactory {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
