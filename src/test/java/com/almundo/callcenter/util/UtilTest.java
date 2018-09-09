package com.almundo.callcenter.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilTest {

    @Test(expected = IllegalAccessError.class)
    public void testUtil() {
        new Util();
    }

    @Test
    public void testGetRandomTimeCall() {
        int result = Util.getRandomTimeCall();
        assertTrue(5 <= result && result <= 10);
    }

}
