package com.example.mybatis.entity;

import lombok.Data;

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
@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Integer clazzId;
}
