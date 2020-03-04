package com.example.master.byd.uitls;

import com.example.master.byd.uitls.exceptio.ApiException;

/**
 * @author dingtao
 * @date 2018/12/30 10:30
 * qq:1940870847
 */
public interface DataCall<T> {

    void success(T data);
    void fail(ApiException e);

}
