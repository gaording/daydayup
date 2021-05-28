package com.example.mybatis.mapper;

import com.example.mybatis.entity.ShopArticle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Copyright: Copyright (c) 2021 IWhaleCloud
 *
 * @program: forOffer
 * @description:
 * @version: v1.0.0
 * @author: gaorunding
 * @date: 2021-05-27 15:28
 * <p>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------ 2021-05-27 gaorunding v1.0.0 修改原因
 */
public interface ShopArticleMapper {
    @Select("select id,name,price,remark from shop_article " +
            "where id in(select article_id from show_item where order_id=#{orderId})")
    List<ShopArticle> selectByOrderId(Integer orderId);
}
