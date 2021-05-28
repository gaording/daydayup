package com.example.mybatis.mapper;

import com.example.mybatis.entity.Student;
import com.example.mybatis.sqlprovider.StudentDynaSqlProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-27 14:35
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-27 gaorunding v1.0.0 修改原因
 */
public interface StudentMapper {
    @Select("select id,name,age,sex,clazz_id from tb_student where clazz_id=#{clazzId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "clazz_id", property = "clazzId")
    })
    List<Student> selectByClazzId(Integer clazzId);

    @SelectProvider(value = StudentDynaSqlProvider.class, method = "selectWithParam")
    List<Student> selectStudents(Student student);
}
