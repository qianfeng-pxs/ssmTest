package com.model.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.bean.Employee;
import com.model.service.EmpService;
import com.model.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/emps/{pageNum}",method = RequestMethod.GET)
    public String getAllEmp(Map<String,Object> map , @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,1);
        List<Employee> employeeList = empService.getAllEmployee();
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,5);
        map.put("empList",employeeList);
        map.put("page",pageInfo);
        return "emplist";
    }

}
