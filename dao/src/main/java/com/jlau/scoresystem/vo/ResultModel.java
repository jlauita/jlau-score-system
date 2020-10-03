package com.jlau.scoresystem.vo;

import java.io.Serializable;

/**
 * Created by cxr1205628673 on 2020/9/16.
 */
public class ResultModel implements Serializable{
    private  int code;
    private  String message;
    private  Object data;
    public static ResultModel ok(){
        ResultModel result = new ResultModel();
        result.message = "ok";
        result.code = 200;
        return result;
    }
    public static ResultModel ok(String msg){
        ResultModel result = new ResultModel();
        result.message = msg;
        result.code = 200;
        return result;
    }
    public static ResultModel ok(String msg,Object data){
        ResultModel result = new ResultModel();
        result.message = msg;
        result.code = 200;
        result.data = data;
        return result;
    }
    public static ResultModel fail(){
        ResultModel result = new ResultModel();
        result.message = "fail";
        result.code = 500;
        return result;
    }
    public static ResultModel fail(String msg){
        ResultModel result = new ResultModel();
        result.message = msg;
        result.code = 500;
        return result;
    }
    public static ResultModel customDefine(String msg,int code){
        ResultModel result = new ResultModel();
        result.message = msg;
        result.code = code;
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
