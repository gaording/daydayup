package com.example.mybatis.mapper;

import com.example.mybatis.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @program: daydayup
 * @description:
 * @author: gaorunding
 * @create: 2021-05-27 14:12
 */
public interface PersonMapper {
    @Select("select id,name,sex,age,card_id from tb_person")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "card_id", property = "card",
                    one = @One(select = "com.example.mybatis.mapper.CardMapper.selectCardById",
                            fetchType = FetchType.EAGER))
    })
    Person selectPersonById(Integer id);
}
