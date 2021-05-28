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
 * @date: 2021-05-27 15:21
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-27 gaorunding v1.0.0 修改原因
 */
@Data
public class ShopUser {
    private Integer id;
    private String username;
    private String loginname;
    private String password;
    private String phone;
    private String address;
    private List<ShopOrder> orders;
}
