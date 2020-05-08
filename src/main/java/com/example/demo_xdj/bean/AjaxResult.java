package com.example.demo_xdj.bean;


public class AjaxResult {

    private Integer code;

    private String msg;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void error(){
        this.code = 0;
        this.msg = "系统错误";
    }

    public void error(String msg) {
        this.code = 0;
        this.msg = msg;
    }

    public void success(String msg, Object data){
        this.code = 1;
        this.msg = msg;
        this.data = data;
    }

    public void success(Object data){
        this.code = 1;
        this.data = data;
    }
}
