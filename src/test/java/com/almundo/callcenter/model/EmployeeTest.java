package com.almundo.callcenter.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.almundo.callcenter.util.TypeEmployee;

public class EmployeeTest {

    @Test
    public void testEmployee() {
        Employee employee = new Employee(TypeEmployee.OPERADOR);
        assertNotNull(employee);
    }

    @Test
    public void testGetTypeEmployee() {
        Employee employee = new Employee(TypeEmployee.OPERADOR);
        assertEquals(TypeEmployee.OPERADOR, employee.getTypeEmployee());
    }

    @Test
    public void testAnswerCalls() throws InterruptedException {
        Employee employee = new Employee(TypeEmployee.OPERADOR);
        Call call = new Call();
        employee.answerCalls(call);
        assertEquals(TypeEmployee.OPERADOR, employee.getTypeEmployee());
    }

    @Test
    public void testIsOccupied() throws InterruptedException {
        Employee employee = new Employee(TypeEmployee.OPERADOR);
        Call call = new Call();
        employee.answerCalls(call);
        assertEquals(false, employee.isOccupied());
    }

}
