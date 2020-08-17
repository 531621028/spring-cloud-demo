package com.hkk.boottest.resp;

import java.util.List;

/**
 * @author kang
 * @since 2020/8/9
 */
public class ListResp<E> extends BaseResp {

    private List<E> result;

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }
}
