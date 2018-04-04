package com.jchaplin;

import com.mysql.DatabaseDriver;
import com.mysql.ReadBlobDemo;
import com.mysql.WriteBlobDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
        // create connection of mysql database and upload image from resources images folder
        WriteBlobDemo writeBlobDemo = new WriteBlobDemo();
        writeBlobDemo.write();

    }

}