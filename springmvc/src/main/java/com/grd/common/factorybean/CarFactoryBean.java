package com.grd.common.factorybean;

import com.grd.common.bean.Car;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 * @program: daydayup
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-28 17:28
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-28 gaorunding v1.0.0 修改原因
 */
public class CarFactoryBean implements FactoryBean<Car> {
    @Setter
    @Getter
    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] split = carInfo.split(",");
        car.setBrand(split[0]);
        car.setMaxSpeed(Integer.parseInt(split[1]));
        car.setPrice(Double.parseDouble(split[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
}
