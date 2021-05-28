package com.example.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-27 14:37
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-27 gaorunding v1.0.0 修改原因
 */
@Data
public class Clazz {
    private Integer id;
    private String code;
    private String name;
    private List<Student> students;
}
