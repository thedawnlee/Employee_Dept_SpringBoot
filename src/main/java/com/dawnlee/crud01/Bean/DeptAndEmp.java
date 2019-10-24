package com.dawnlee.crud01.Bean;

public class DeptAndEmp {

    private Employee employee;
    private Department department;

    @Override
    public String toString() {
        return "DeptAndEmp{" +
                "employee=" + employee +
                ", department=" + department +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
