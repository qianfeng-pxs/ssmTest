package com.model.dao;

import com.model.bean.Employee;

import java.util.List;

public interface EmpMapper {

    List<Employee> getAllEmployee();

    Employee getEmployee(String eid);

    void updateEmployee(Employee employee);


}
