package com.example.mybatis.mapper;

import com.example.mybatis.entity.Clazz;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @program: daydayup
 * @description:
 * @author: gaorunding
 * @create: 2021-05-27 14:39
 */
public interface ClazzMapper {
    @Select("select id,code,name from tb_clazz")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "code", property = "code"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "students",
                    many = @Many(select = "com.example.mybatis.mapper.StudentMapper.selectByClazzId",
                            fetchType = FetchType.LAZY))
    })
    Clazz selectClazzById(Integer id);
}
