package com.lordbao.mapper;

import com.lordbao.beans.Employee;

/**
 * @Author Lord_Bao
 * @Date 2024/7/31 12:22
 * @Version 1.0
 */
public interface EmployeeMapper {

    Employee queryById(Integer id);
}
