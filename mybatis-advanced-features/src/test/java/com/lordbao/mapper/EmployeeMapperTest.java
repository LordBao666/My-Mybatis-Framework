package com.lordbao.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lordbao.beans.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/8/4 17:15
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
    public void queryAllEmployee() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        //注意一个分页只能有一条查询语句
        PageHelper.startPage(2,2);
        List<Employee> list=mapper.queryAllEmployee();
        //pageInfo 获取分页的数据
        PageInfo <Employee> pageInfo = new PageInfo<>(list);

        //当前页的数据
        List<Employee> list1 = pageInfo.getList();
        System.out.println(list1);
        //总页数
        System.out.println("pages: "+pageInfo.getPages());
        //总条目数
        System.out.println("totalRecords: "+pageInfo.getTotal());
        //当前页是第几页
        System.out.println("currentPageNum: "+pageInfo.getPageNum());
        //当前页大小
        System.out.println("pageSize:"+pageInfo.getPageSize());

    }
}