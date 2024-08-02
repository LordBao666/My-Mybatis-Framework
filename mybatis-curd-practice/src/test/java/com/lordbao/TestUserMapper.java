package com.lordbao;

import com.lordbao.beans.User;
import com.lordbao.mapper.UserMapper;
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
 * @Date 2024/8/2 11:16
 * @Version 1.0
 */

public class TestUserMapper {
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
    // 尽管commit 不需要对DQL语句使用，但为了一致性还是这样写。
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }

    @Test
    public void testSelectById(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        int id=1;
        User user = mapper.selectById(id);
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = new User();
        u.setUsername("jack");
        u.setPassword("123456");
        int row = mapper.insert(u);
        System.out.println(row);
        //主键回显
        System.out.println(u.getId());
    }


    @Test
    public void testUpdate(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = new User();
        u.setId(1);
        u.setUsername("tom");
        u.setPassword("123456");
        mapper.update(u);

        User user = mapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testSelectAll(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        users.forEach(System.out::println);
    }

    @Test
    public void delete(){
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.delete(3);
    }
}
