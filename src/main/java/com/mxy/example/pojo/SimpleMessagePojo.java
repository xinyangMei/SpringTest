package com.mxy.example.pojo;


import java.io.Serializable;

/**
 * @author zhuweifeng
 * @Title:
 * @Description: 方法返回信息汇总pojo
 * @date 2017年03月29日 12:13
 */
public class SimpleMessagePojo<T> implements Serializable {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 异常信息
     */
    private String message;

    /**
     * 目标返回对象
     */
    private T obj;


    /**
     * 初始化，默认成功
     */
    public SimpleMessagePojo() {
        this.success = true;
        this.obj = null;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setFalse(String message) {
        this.success = false;
    }


}
