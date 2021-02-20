package com.model.service.Impl;


import com.model.bean.Employee;
import com.model.dao.EmpMapper;
import com.model.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "empService")
public class EmpServiceImp implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Employee> getAllEmployee() {

        return empMapper.getAllEmployee();
    }

    @Override
    public Employee getEmployee(String eid) {
        return empMapper.getEmployee(eid);
    }

    @Override
    public void updateEmployee(Employee employee) {
        empMapper.updateEmployee(employee);
    }
}