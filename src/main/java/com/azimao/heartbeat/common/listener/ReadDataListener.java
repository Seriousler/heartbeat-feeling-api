package com.azimao.heartbeat.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/*
 *@ClassName ReadDataListener
 *@Description TODO
 *@Author 张隆
 *@Date 2023/3/17 14:26
 *@Version 1.0
 */

/**
 * 模板的读取类
 */
// 有个很重要的点 Listener 不能被spring管理，要每次读取excel都要new，然后里面用到spring可以构造方法传进去
@Slf4j
public class ReadDataListener<T> implements ReadListener<T> {

    /**
     * 每隔5条存储数据库，实际使用中可以10000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 10000;
    /**
     * 缓存的数据
     */
    private List<T> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(T t, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(t));
        cachedDataList.add(t);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            log.info("解析到的数据超过{}上限", BATCH_COUNT);
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }

    public List<T> getReadDatas() {
        return cachedDataList;
    }

}
