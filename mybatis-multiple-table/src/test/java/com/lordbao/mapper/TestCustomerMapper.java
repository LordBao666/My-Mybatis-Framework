package com.lordbao.mapper;

import com.lordbao.beans.Customer;
import com.lordbao.beans.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Lord_Bao
 * @Date 2024/8/2 17:08
 * @Version 1.0
 */
class TestCustomerMapper {

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
    public void selectCustomerWithOrderList() {
        CustomerMapper mapper = session.getMapper(CustomerMapper.class);
        Customer customer = mapper.selectCustomerWithOrderList(1);
        System.out.println(customer);
    }
}