package com.kelvin.dockerdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Properties;

@RestController
public class HelloController {
//    static final String FILE_PATH = "D:/ITA/docker/res";
    static final String FILE_PATH = "/usr/res";

    @RequestMapping("/docker/hello")
    public String hello(){
        return "hello DockerFile";
    }

    @RequestMapping("/docker/print")
    public String print() throws IOException {
        StringBuilder sb = new StringBuilder("");
        Properties p = new Properties();
        p.load(new FileInputStream(FILE_PATH + "/my_config.properties"));
        sb.append("fname: ").append(p.getProperty("fname")).append("; ")
            .append("age:").append(p.getProperty("age")).append("; ")
            .append("phone:").append(p.getProperty("phone"));
        return "Config Content=> " + sb.toString();
    }

    @RequestMapping("/docker/write")
    public String write(String fname, String phone) throws IOException {
        File file = new File(FILE_PATH + "/out.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        StringBuilder sb = new StringBuilder("");
        sb.append("fname: ").append(fname).append("\n")
            .append("phone: ").append(phone);
        out.write(sb.toString().getBytes());
        out.flush();
        out.close();
        return "Write Success: " + sb.toString();
    }
}
