package com.demo.webservice;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Restful ws接口
 * @author eatcrow
 * @create 2018-08-13 15:27
 **/
@WebService
public interface RsWebService {

    /*
     *  测试
     */
    @GET
    @Path("/test")
    public String test();

    /**
     *  测试get带参数
     * @param question
     * @return
     */
    @GET    //  请求方式
    @Path("/chat")  //  请求路径
    @Produces(MediaType.TEXT_PLAIN)     // 请求返回的数据类型
    public String chat(@QueryParam("question") String question);

    /**
     *  异常抛出
     */
    @GET
    @Path("/throw")
    @Produces(MediaType.APPLICATION_JSON)
    public void throwException();
}
