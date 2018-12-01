package com.lc.springboot.demo3;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientTest {


    @Test
    public void httpClient() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet("http://www.cnblogs.com/feiyu2018/p/9426920.html");

        CloseableHttpResponse response = httpClient.execute(get);

        HttpEntity entity = response.getEntity();

        System.err.println(EntityUtils.toString(entity));
    }
}
