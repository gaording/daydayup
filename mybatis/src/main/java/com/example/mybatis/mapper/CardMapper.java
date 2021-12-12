package com.example.mybatis.mapper;

import com.example.mybatis.entity.Card;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @program: daydayup
 * @description:
 * @author: gaorunding
 * @create: 2021-05-27 14:12
 */
public interface CardMapper {
    @Select("select id,code from tb_card where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "code", property = "code")
    })
    Card selectCardById(Integer id);
}
