package com.activite3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests unitaires de la classe Console.
 **/
public class ConsoleTest {
    @Test
    public void foreground() {
        Assert.assertEquals(Console.FOREGROUNDS.length, 16);
    }

    @Test
    public void hasValue() {
        Assert.assertNotNull(Console.ANSI_BLACK);
    }
}
