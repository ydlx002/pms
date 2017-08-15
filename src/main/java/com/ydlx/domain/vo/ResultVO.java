package com.ydlx.domain.vo;

import com.ydlx.constants.ResultType;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/5/3.
 */
public class ResultVO implements Serializable{

    /***结果码*/
    private String resultCode;

    /**结果描述*/
    private String resultDesc;

    /**结果集*/
    private Object data;


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultVO setResultVO(ResultType resultType){
        this.setResultCode(resultType.getReturnCode());
        this.setResultDesc(resultType.getReturnDesc());
        return this;
    }


    public ResultVO(){

    }

    public ResultVO(ResultType resultType){
        this.setResultCode(resultType.getReturnCode());
        this.setResultDesc(resultType.getReturnDesc());
    }
}
