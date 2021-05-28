package com.example.mybatis.sqlprovider;

import com.example.mybatis.entity.Student;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-27 16:12
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-27 gaorunding v1.0.0 修改原因
 */
public class StudentDynaSqlProvider {
    public String selectWithParam(Student student) {
        return new SQL() {{
            SELECT("*");
            FROM("tb_student");
            if (null != student.getId()) {
                WHERE("id=#{id}");
            }
            if (StringUtils.isNotEmpty(student.getName())) {
                WHERE("name=#{name}");
            }
            if (StringUtils.isNotEmpty(student.getSex())) {
                WHERE("sex=#{sex}");
            }
        }}.toString();
    }
}
