package com.almundo.callcenter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListNodesTest {

    @Test
    public void testList() {
        ListNodes<Call> listCall = new ListNodes<>();
        assertNotNull(listCall);
    }

    @Test
    public void testIsEmpty() {
        ListNodes<Call> listCall = new ListNodes<>();
        assertTrue(listCall.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        ListNodes<Call> listCall = new ListNodes<>();
        listCall.addNode(new Call());
        assertEquals(false, listCall.isEmpty());
    }

    @Test
    public void testGetSize() {
        ListNodes<Call> listCall = new ListNodes<>();
        assertEquals(0, listCall.getSize());
    }

    @Test
    public void testAddNodo() {
        ListNodes<Call> listCall = new ListNodes<>();
        listCall.addNode(new Call());
        assertEquals(1, listCall.getSize());
    }

    @Test
    public void testGetNodo() {
        ListNodes<Call> listCall = new ListNodes<>();
        listCall.addNode(new Call());
        Call result = listCall.getNode();
        System.out.println("La llamada dura ".concat(String.valueOf(result.getDuration())).concat(" segundos"));
        assertEquals(0, listCall.getSize());
    }

}
