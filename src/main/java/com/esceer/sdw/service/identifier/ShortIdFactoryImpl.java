package com.esceer.sdw.service.identifier;

import java.util.UUID;

public final class ShortIdFactoryImpl implements IdFactory {

    @Override
    public String generateId() {
        UUID uuid = UUID.randomUUID();
        return Long.toString(uuid.getLeastSignificantBits(), Character.MAX_RADIX).substring(2);
    }
}
