package com.example.mybatis.mapper;

import com.example.mybatis.entity.ShopOrder;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @program: daydayup
 * @description:
 * @author: gaorunding
 * @create: 2021-05-27 15:34
 */
public interface ShopOrderMapper {
    @Select("select id,code,total,user_id from shop_order where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "code", property = "code"),
            @Result(column = "total", property = "total"),
            @Result(column = "user_id", property = "user",
                    one = @One(select = "com.example.mybatis.mapper.ShopUserMapper.selectById",
                            fetchType = FetchType.LAZY)),
            @Result(column = "id", property = "articles",
                    many = @Many(select = "com.example.mybatis.mapper.ShopArticleMapper.selectByOrderId",
                            fetchType = FetchType.LAZY))
    })
    ShopOrder selectById(Integer id);
}
