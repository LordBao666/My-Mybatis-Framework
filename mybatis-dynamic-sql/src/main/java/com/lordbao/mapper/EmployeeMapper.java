package com.lordbao.mapper;

import com.lordbao.beans.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/8/3 14:27
 * @Version 1.0
 */
public interface EmployeeMapper {
    /**
     * 此函数在xml的实现在逻辑上是有些许问题的，但我们这里仅关注where标签的使用
     */
    List<Employee> selectNameAndSalary(@Param("name")String name,@Param("salary")Double salary);

    /**
     * @param employee 根据employee 的 empId 将数据库对应表项更新为employee的所有属性(如果属性非空的话)。
     *                 保证 employee 的 empId 不能为null，employee 的 empName 和 empSalary不能全为null
     * @return 返回数据库影响行数.
     */
    int update(Employee employee);


    /**
     *
     * 根据ids 批量查询，返回结果集List
     */
    List<Employee> queryBatch(@Param("list")List<Integer>ids);

    /**
     *
     * 根据ids 批量删除，返回影响行数
     */
    int deleteBatch(@Param("list")List<Integer>ids);


    /**
     *
     * 根据list 批量插入，返回影响行数
     */
    int insertBatch(@Param("list")List<Employee> list);

    /**
     *
     * 根据list 批量更新，返回影响行数
     */
    int updateBatch(@Param("list")List<Employee> list);
}
