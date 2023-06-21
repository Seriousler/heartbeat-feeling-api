package com.azimao.heartbeat.common.entity;

import java.util.Collection;

public class Wrapper<T> {

    /**
     * 成功
     */
    protected static final String CODE_SUCCESS = "0";
    /**
     * 默认失败
     */
    private static final String CODE_ERROR_DEFAULT = "COMMONS_DEFAULT_ERROR";

    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 总数量
     */
    private Number total;
    /**
     * 返回结果
     */
    private T data;

    public static boolean isSuccess(Wrapper<?> wrapper) {
        return wrapper != null && CODE_SUCCESS.equals(wrapper.getCode());
    }

    public static <T> Wrapper<T> success(String msg) {
        Wrapper<T> result = new Wrapper<>();
        result.setCode(CODE_SUCCESS);
        result.setMsg(msg);
        return result;
    }

    public static <T> Wrapper<T> success() {
        Wrapper<T> result = new Wrapper<>();
        result.setCode(CODE_SUCCESS);
        result.setMsg("操作成功");
        return result;
    }

    public static <T> Wrapper<T> result(T data) {
        Wrapper<T> wrapper = new Wrapper<>();
        wrapper.setCode(CODE_SUCCESS);
        wrapper.setData(data);
        Number total = null;
        if (data != null) {
            total = data instanceof Collection ? ((Collection<?>) data).size() : 1;
        }
        wrapper.setTotal(total);
        return wrapper;
    }

    @SuppressWarnings("unchecked")
    public static <T, C extends Collection<T>> Wrapper<C> list(Collection<T> list) {
        Wrapper<Collection<T>> wrapper = new Wrapper<>();
        wrapper.setCode(CODE_SUCCESS);
        wrapper.setData(list);
        wrapper.setTotal(list == null ? 0 : list.size());
        return (Wrapper<C>) wrapper;
    }

    public static <T> Wrapper<T> error(String msg) {
        return error(CODE_ERROR_DEFAULT, msg);
    }

    public static <T> Wrapper<T> error(String code, String msg) {
        Wrapper<T> wrapper = new Wrapper<>();
        wrapper.setCode(code);
        wrapper.setMsg(msg);
        return wrapper;
    }

    @SuppressWarnings("unchecked")
    public static <T, C extends Collection<T>> Wrapper<C> page(Collection<T> data, Number total) {
        Wrapper<Collection<T>> result = new Wrapper<>();
        result.setCode(CODE_SUCCESS);
        result.setData(data);
        result.setTotal(total);
        return (Wrapper<C>) result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public <E> Wrapper<E> as() {
        return (Wrapper) this;
    }

}