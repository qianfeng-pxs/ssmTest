package com.model.service;

import com.model.bean.Employee;

import java.util.List;

public interface EmpService {

    List<Employee> getAllEmployee();

    Employee getEmployee(String eid);

    void updateEmployee(Employee employee);


}
