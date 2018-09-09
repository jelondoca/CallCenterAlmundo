package com.almundo.callcenter.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.almundo.callcenter.util.Instances;
import com.almundo.callcenter.util.TypeEmployee;

public class Employee {
    private TypeEmployee typeEmployee;
    private boolean occupied;
    private static final Logger logger = LogManager.getLogger(Employee.class);

    public Employee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
        this.occupied = false;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
    }

    public String answerCalls(Call call) throws InterruptedException {
        this.occupied = true;
        int duration = call.getDuration() * 1000;
        logger.debug(Thread.currentThread() + " Inicia la llamada con " + this.typeEmployee);
        Thread.sleep(duration);
        logger.debug(Thread.currentThread() + " Finaliza la llamada" + this.typeEmployee);
        logger.info(Thread.currentThread().getName().concat(" Llamada atendida por ").concat(String.valueOf(typeEmployee))
                .concat(" con una duración de ").concat(String.valueOf(call.getDuration())).concat(" segundos"));
        this.occupied = false;
        Instances.minusCountEmployee();
        return ("Llamada atendida por ".concat(String.valueOf(typeEmployee)).concat(" con una duración de ")
                .concat(String.valueOf(call.getDuration())).concat(" segundos"));
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupied() {
        this.occupied = true;
    }
}
