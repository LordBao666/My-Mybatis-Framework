package com.lordbao.mapper;

import com.lordbao.beans.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/8/3 14:35
 * @Version 1.0
 */
class EmployeeMapperTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("MyBatisConfig.xml"))
                .openSession();
    }
    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }

    @Test
    public void selectNameAndSalary() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employeeList=mapper.selectNameAndSalary(null,100.0);
        System.out.println(employeeList);

        employeeList= mapper.selectNameAndSalary(null,101.0);
        System.out.println(employeeList);

        employeeList= mapper.selectNameAndSalary("tom",200.33);
        System.out.println(employeeList);

    }

    @Test
    public void update() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee e= new Employee();
//        e.setEmpId(1);
//        e.setEmpSalary(200.22);
//        e.setEmpName("jojo");
//        mapper.update(e);

//        e.setEmpId(1);
//        e.setEmpSalary(200.33);
//        e.setEmpName(null);
//        mapper.update(e);

        e.setEmpId(1);
        e.setEmpSalary(null);
        e.setEmpName("jack");
        mapper.update(e);

    }

    @Test
    public void queryBatch() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Employee> employeeList=mapper.queryBatch(list);
        employeeList.forEach(System.out::println);
    }

    @Test
    public void deleteBatch() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        int rows=mapper.deleteBatch(list);
        System.out.println(rows);
    }

    @Test
    public void insertBatch() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(null,"jojo1",200.1));
        list.add(new Employee(null,"jojo2",200.2));
        list.add( new Employee(null,"jojo3",200.3)) ;
        int rows=mapper.insertBatch(list);
        System.out.println(rows);
    }

    @Test
    public void updateBatch() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(4,"jojo1",200.1+0.1));
        list.add(new Employee(5,"jojo2",200.2+0.1));
        list.add( new Employee(6,"jojo3",200.3+0.1)) ;
        int rows=mapper.updateBatch(list);
        System.out.println(rows);
    }
}