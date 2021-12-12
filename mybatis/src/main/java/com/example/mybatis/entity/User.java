package com.example.mybatis.entity;

import lombok.Data;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-19 14:50
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-19 gaorunding v1.0.0 修改原因
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
}
