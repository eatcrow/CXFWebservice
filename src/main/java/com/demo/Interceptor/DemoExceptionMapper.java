package com.demo.Interceptor;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * 异常统一处理类
 * @author jijianmin
 * @create 2018-07-09 19:36
 **/
public class DemoExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        //  TODO: 异常的日志记录/封装成自定义的异常等等
        String returnStr = "异常 ："+ e.getClass().getTypeName();

        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                entity(returnStr).type("application/json;charset=UTF-8").build();
    }
}
