package com.lc.springboot.demo2;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo2 {

    public static void main(String[] args) throws Exception {
        //建立一个新的请求客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //使用HttpGet方式请求网址
        HttpGet httpGet = new HttpGet("http://www.datalearner.com/blog");

        //获取网址的返回结果
        CloseableHttpResponse response = null;
        response = httpClient.execute(httpGet);

        //获取返回结果中的实体
        HttpEntity entity = response.getEntity();

        //将返回的实体输出
//            System.out.println(EntityUtils.toString(entity));
//            EntityUtils.consume(entity);
        System.err.println("----------------");
        System.err.println(EntityUtils.toString(entity));
    }
}
