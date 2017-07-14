package com.sein.pojo.dto;

import java.util.List;

/**
 * Created by ldb on 2017/6/18.
 */
public class TransformGPSResult {

    private int status;
    private List<GPS> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<GPS> getResult() {
        return result;
    }

    public void setResult(List<GPS> result) {
        this.result = result;
    }

}

