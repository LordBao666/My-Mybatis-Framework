package com.lordbao.mapper;

import com.lordbao.beans.User;

import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/8/2 11:05
 * @Version 1.0
 */
public interface UserMapper {

    int insert(User user);

    int update(User user);

    int delete(Integer id);

    User selectById(Integer id);

    List<User> selectAll();
}
