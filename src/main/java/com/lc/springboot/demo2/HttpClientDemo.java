package com.lc.springboot.demo2;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientDemo {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建 httpClient 实例
        HttpGet httpget = new HttpGet("https://www.oschina.net/news/project"); // 创建 httpget 实例
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpget);
        } catch (ClientProtocolException e) {  // http 协议异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) { // io 异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 执行 get 请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
            System.out.println("网页内容：" + EntityUtils.toString(entity, "utf-8"));

        try {
            response.close();
        } catch (IOException e) {  // io 异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 关闭流和释放系统资源
    }

}
