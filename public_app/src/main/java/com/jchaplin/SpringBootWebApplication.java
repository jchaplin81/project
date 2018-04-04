package com.jchaplin;

import com.mysql.ReadBlobDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
        // read image from mysql database
        ReadBlobDemo readBlobDemo = new ReadBlobDemo();
        readBlobDemo.read();

    }

}