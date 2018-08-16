package com.demo.webservice;

/**
 * Restful ws接口实现类
 * @author eatcrow
 * @create 2018-07-09 15:26
 **/
public class RsWebServiceImpl implements RsWebService{

    @Override
    public String test() {
        return "success";
    }

    @Override
    public String chat(String question) {
        return "Q :" + question + "  A: silent";
    }

    @Override
    public void throwException() {
        throw new NullPointerException();
    }
}
