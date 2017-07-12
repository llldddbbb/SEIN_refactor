package com.sein.pojo.dto;

/**
 * Created by ldb on 2017/7/12.
 * 通用返回类
 */
public class Result {

    //返回的数据
    private Object data;
    //返回的提示信息
    private String msg;
    //响应的业务状态:是否响应成功
    private boolean success;

    /**
     * 响应成功:不带参数
     * @return
     */
    public static Result isOK(){
        return new Result(true);
    }

    /**
     * 响应成功:绑定数据
     * @param data
     * @return
     */
    public static Result isOK(Object data){
        return new Result(data,true);
    }

    /**
     * 响应失败:不带参数
     * @return
     */
    public static Result isNotOK(){
        return new Result(false);
    }

    /**
     * 响应失败:带错误信息
     * @param msg
     * @return
     */
    public static Result isNotOK(String msg){
        return new Result(msg,false);
    }

    public Result() {
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(Object data, boolean success) {
        this.data = data;
        this.success = success;
    }


    public Result(String msg, boolean success) {
        this.msg = msg;
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
