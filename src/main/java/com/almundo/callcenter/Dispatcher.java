package com.almundo.callcenter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.util.Instances;

public class Dispatcher {
    private static final Logger logger = LogManager.getLogger(Dispatcher.class);

    public String dispatchCall() throws InterruptedException {
        Call call = new Call();
        String result = null;
        Employee employee;
        employee = Instances.getEmployee();
        if (employee == null) {
            logger.info(Thread.currentThread().getName() + " Llamada en espera");
            Instances.getListCall().addNode(call);
            employee = Instances.callWaiting();
        }
        result = Thread.currentThread() + " " + employee.answerCalls(call);
        return result;
    }

}
