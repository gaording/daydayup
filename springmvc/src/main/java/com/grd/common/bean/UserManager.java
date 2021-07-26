package com.grd.common.bean;

import java.util.Date;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-29 19:35
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-29 gaorunding v1.0.0 修改原因
 */
public class UserManager {
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        System.out.println(this + "setDate:" + date);
        this.date = date;
    }
}
