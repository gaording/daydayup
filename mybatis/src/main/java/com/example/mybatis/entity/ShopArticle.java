package com.example.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-27 15:21
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-27 gaorunding v1.0.0 修改原因
 */
@Data
public class ShopArticle {
    private Integer id;
    private String name;
    private Double price;
    private String remark;
    private List<ShopOrder> orders;
}
