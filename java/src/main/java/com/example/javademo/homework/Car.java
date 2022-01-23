package com.example.javademo.homework;

import lombok.Data;

/**
 * @program: daydayup
 * @description:
 * @author: gaorunding
 * @create: 2021-05-31 14:04
 */
@Data
public abstract class Car {
    private double speed;
    private double price;

    public abstract void buy();

}

class Tractor extends Car {

    @Override
    public void buy() {
        //拖拉机库存-1，记录该订单
        double balance = 100 - getPrice();
    }

}

