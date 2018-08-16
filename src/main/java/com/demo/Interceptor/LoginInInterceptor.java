package com.demo.Interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录拦截器类
 * @author eatcrow
 * @create 2018-07-09 18:24
 **/
public class LoginInInterceptor extends AbstractPhaseInterceptor<Message> {

    public LoginInInterceptor(String phase) {
        super(phase);
    }

    public LoginInInterceptor() {
        //  接收
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        //  获取请求对象
        HttpServletRequest httpRequest = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
        String uri = httpRequest.getRequestURI();
        String ip = getIpAddress(httpRequest);
        //  TODO:处理请求

    }

    /**
     *  从httpservletrequest中获取ip
     * @param request 请求对象
     * @return ip
     */
    private static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
