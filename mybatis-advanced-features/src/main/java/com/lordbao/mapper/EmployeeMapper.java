package com.lordbao.mapper;

import com.lordbao.beans.Employee;

import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/8/4 16:20
 * @Version 1.0
 */
public interface EmployeeMapper {
    List<Employee> queryAllEmployee();
}
