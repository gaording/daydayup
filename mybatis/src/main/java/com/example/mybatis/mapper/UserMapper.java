package com.example.mybatis.mapper;

import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: forOffer
 * @description:
 * @author: gaorunding
 * @create: 2021-05-27 09:59
 */
public interface UserMapper {

    @Insert("insert into tb_user(name,sex,age) values(#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveUser(User user);

    User selectUserById(@Param("id") int id);

    List<User> selectAllUsers();

    int deleteUserById(int id);
}
