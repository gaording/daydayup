package com.grd.common.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-06-29 20:33
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-06-29 gaorunding v1.0.0 修改原因
 */
public class DatePropertyEditorRegister implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
