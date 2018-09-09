package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.Test;

public class DispatcherTest {

    private ExecutorService executor;

    @Test
    public void testDispatch10Calls() throws Exception {
        int limitThreadsCall = 10;
        List<Calls> listCalls = new ArrayList<>();
        executor = Executors.newFixedThreadPool(limitThreadsCall);
        IntStream.range(0, limitThreadsCall).forEach(i -> listCalls.add(new Calls()));
        executor.invokeAll(listCalls);
    }
    
    @Test
    public void testDispatch20Calls() throws Exception {
        int limitThreadsCall = 20;
        List<Calls> listCalls = new ArrayList<>();
        executor = Executors.newFixedThreadPool(limitThreadsCall);
        IntStream.range(0, limitThreadsCall).forEach(i -> listCalls.add(new Calls()));
        executor.invokeAll(listCalls);
    }

}
