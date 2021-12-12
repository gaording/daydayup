package com.grd.common.bean;

import lombok.Data;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-28 17:27
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-28 gaorunding v1.0.0 修改原因
 */
@Data
public class Car {
    private int maxSpeed;
    private String brand;
    private double price;
}
