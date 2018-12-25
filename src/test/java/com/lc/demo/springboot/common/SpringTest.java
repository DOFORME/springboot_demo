package com.lc.demo.springboot.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileReader;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {

    private static final String FILE_PATH = "C:\\Users\\Administrator\\Desktop\\test.txt";

    @Test
    public void testInputStreamResource() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\test.txt";
        Resource resource = new FileSystemResource(filePath);
        InputStream is = resource.getInputStream();
        byte[] cache = new byte[1];
        int i;
        while ((i = is.read(cache)) != -1) {
            System.err.println((char) cache[0]);
        }
    }

    @Test
    public void testJdkInputSteam() throws Exception {
        FileReader fr = new FileReader(FILE_PATH);
        char[] cache = new char[10];
        while (fr.read(cache) != -1) {
            System.err.println(cache);
        }
    }
}
