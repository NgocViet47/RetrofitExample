package com.example.mypc.retrofitexample.model;

/**
 * Created by VuPhan on 4/4/17.
 */

public class ErrorCode {

    private String err_message;
    private int err_code;

    public ErrorCode() {
    }

    public String getErr_message() {
        return err_message;
    }

    public void setErr_message(String err_message) {
        this.err_message = err_message;
    }

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }
}
