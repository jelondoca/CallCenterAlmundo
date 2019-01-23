package com.almundo.callcenter.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.ListNodes;

public class Instances {

    private static ListNodes<Call> listCall;
    private static List<Employee> listEmployees;
    private static final Logger logger = LogManager.getLogger(Instances.class);
    private static final int LIMIT_OPERATORS = 6;
    private static final int LIMIT_SUPERVISORS = 3;
    private static final int LIMIT_DIRECTORS = 1;
    private static Integer countEmployees;

    Instances() {
        throw new IllegalAccessError("Utility class");
    }

    public static synchronized ListNodes<Call> getListCall() {
        if (listCall == null) {
            logger.debug("Construyendo lista de espera");
            listCall = new ListNodes<>();
        }
        return listCall;
    }

    private static synchronized Integer getCountEmployees() {
        if (countEmployees == null) {
            countEmployees = Integer.valueOf(0);
        }
        return countEmployees;
    }

    private static synchronized void addCountEmployees() {
        getCountEmployees();
        countEmployees++;
    }

    private static synchronized void minusCountEmployees() {
        getCountEmployees();
        if (countEmployees > 0) {
            countEmployees--;
        }
    }

    private static synchronized List<Employee> getListEmployees() {
        if (listEmployees == null) {
            getCountEmployees();
            logger.debug("Construyendo lista de Empleados");
            listEmployees = new ArrayList<>();
            for (int i = 0; i < LIMIT_OPERATORS; i++) {
                listEmployees.add(new Employee(TypeEmployee.OPERADOR));
            }
            for (int i = 0; i < LIMIT_SUPERVISORS; i++) {
                listEmployees.add(new Employee(TypeEmployee.SUPERVISOR));
            }
            for (int i = 0; i < LIMIT_DIRECTORS; i++) {
                listEmployees.add(new Employee(TypeEmployee.DIRECTOR));
            }
        }
        return listEmployees;
    }

    public static synchronized Employee getEmployee() {
        Employee employee = null;
        if (getListEmployees().size() > getCountEmployees().intValue()) {
            employee = getListEmployees().get(getCountEmployees());
            addCountEmployees();
            employee.occupied();
            logger.info(Thread.currentThread().getName() + " Llamada asignada al empleado " + employee.getTypeEmployee());
        }
        return employee;
    }

    public static synchronized Employee getEmployeeWaiting() {
        Employee employee = null;
        if (getListEmployees().size() > getCountEmployees().intValue()) {
            employee = getListEmployees().stream().filter(e -> !e.isOccupied()).findFirst().orElse(null);
            if (employee != null) {
                addCountEmployees();
                employee.occupied();
                logger.info(Thread.currentThread().getName() + " Llamada asignada al empleado " + employee.getTypeEmployee());
            }
        }
        return employee;
    }

    public static void minusCountEmployee() {
        minusCountEmployees();
    }

    public static boolean isFreeEmployees() {
        return getCountEmployees().intValue() < listEmployees.size();
    }
    
    public static Employee callWaiting() {
        Employee employee;
        while (!isFreeEmployees()) {
            // This while is used for wait fremoon the employee
        }
        employee = getEmployeeWaiting();
        if (employee == null) {
            employee = callWaiting();
        }
        return employee;
    }


}
