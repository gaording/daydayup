package com.grd.common.config;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-29 19:41
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-29 gaorunding v1.0.0 修改原因
 */
public class DateProopertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
