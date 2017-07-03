package com.example.mypc.retrofitexample.model.responseResultModel;

import com.example.mypc.retrofitexample.model.ErrorCode;

/**
 * Created by VuPhan on 3/2/17.
 */

public class ResultResponse<T> {

    private T data;
    private boolean success;
    private String message;
    private ErrorCode err;
    private int status_code;

    public ResultResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCode getErr() {
        return err;
    }

    public void setErr(ErrorCode err) {
        this.err = err;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }
}
