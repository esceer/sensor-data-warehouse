package com.esceer.sdw.service.identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class ShortIdFactoryImplTest {

    private final ShortIdFactoryImpl testable = new ShortIdFactoryImpl();

    @Test
    public void testTenThousandRandomGeneratedIdsAreUnique() {
        final int numOfCycles = 10_000;
        assertEquals(numOfCycles,
            Stream.generate(testable::generateId)
                .limit(numOfCycles)
                .distinct()
                .count(),
            "Non-unique id found!");
    }
}
