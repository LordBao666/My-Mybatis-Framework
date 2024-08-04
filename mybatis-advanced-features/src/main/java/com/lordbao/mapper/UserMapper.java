package com.lordbao.mapper;

import com.lordbao.beans.User;

/**
* @author LordBao
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-08-04 20:22:13
* @Entity com.lordbao.beans.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
