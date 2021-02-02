package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    Employee getEmployeeByConditionChoose(Employee employee);

    void updateEmployeeByConditionSet(Employee employee);

    List<Employee> getEmployeesByConditionForeach(@Param("ids") List<Integer> ids);

    Employee getEmployeeByLocalCache(Integer id);
    Employee getEmployeeBySecondLevelCache(Integer id);

    List<Employee> getEmployees();
}
