package com.azimao.heartbeat.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 *@ClassName MyMetaObjectHandler
 *@Description TODO
 *@Author 张隆
 *@Date 2022/10/18 10:29
 *@Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 插入时候的填充策略
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("start insert fill");
        //添加时候自动填充 setFieldValByName三个参数为：映射类字段，填充值，原对象
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createBy", null, metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", null, metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    /**
     * 更新时候的填充策略
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("start update fill");
        this.setFieldValByName("updateBy", null, metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

}
