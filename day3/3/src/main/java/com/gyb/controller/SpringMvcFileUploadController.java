package com.gyb.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author gb
 * @Date 2020/7/14 16:29
 * @Version 1.0
 * description:
 */
@Controller
@RequestMapping("springMvcFileUploadController")
public class SpringMvcFileUploadController {
    /**
     * create by: gb
     * description: 将文件上传到2项目中
     * create time: 2020/7/14 16:30
     *
     * @param
     * @return
     */
    @RequestMapping("fileUpload")
    public String fileUpload(MultipartFile upload) throws IOException {
        System.out.println("SpringMVC");
//定义上传的路径
        String path = "http://localhost:9090/uploads/";

//        获取上传文件的名称
        String filename = upload.getOriginalFilename();
//        把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
//        完成跨服务器上传
//创建客户端对象
        Client client = Client.create();
//        和2服务器相连接
        WebResource resource = client.resource(path + filename);
//        上传文件()
        resource.put(upload.getBytes());
        return "success";
    }
}
