package com.example.mybatis.mapper;

import com.example.mybatis.entity.ShopUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @program: forOffer
 * @description:
 * @author: gaorunding
 * @create: 2021-05-27 15:25
 */
public interface ShopUserMapper {
    @Select("select id,username,loginname,phone,address from shop_user where id=#{userId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "loginname", property = "loginname"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address")
    })
    ShopUser selectById(Integer userId);
}
