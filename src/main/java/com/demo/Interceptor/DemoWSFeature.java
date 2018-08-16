package com.demo.Interceptor;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.InterceptorProvider;

/**
 * 拦截器捆绑类
 * @author eatcrow
 * @create 2018-07-09 18:22
 **/
public class DemoWSFeature extends AbstractFeature {

    @Override
    protected void initializeProvider(InterceptorProvider provider, Bus bus) {
        //  登录拦截器捆绑
        provider.getInInterceptors().add(new LoginInInterceptor());
        //inInterceptors	    拦截接收到的消息
        //inFaultInterceptors	拦截接收错误消息
        //outInterceptors	    拦截发出去的消息
        //outFaultInterceptors	拦截发出去的错误消息
    }
}
