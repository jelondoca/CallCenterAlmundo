package com.almundo.callcenter;

import java.util.concurrent.Callable;

public class Calls implements Callable<String> {

    private Dispatcher dispatcher = new Dispatcher();

    @Override
    public String call() throws InterruptedException {
        return (dispatcher.dispatchCall());
    }

}
