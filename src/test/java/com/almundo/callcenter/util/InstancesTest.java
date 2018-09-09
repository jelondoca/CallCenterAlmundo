package com.almundo.callcenter.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class InstancesTest {

    @Test(expected = IllegalAccessError.class)
    public void testInstances() {
        new Instances();
    }

    @Test
    public void testGetListCall() {
        assertNotNull(Instances.getListCall());
        assertNotNull(Instances.getListCall());
    }

    @Test
    public void testGetListEmployees() {
        assertNotNull(Instances.getEmployee());
    }

}
