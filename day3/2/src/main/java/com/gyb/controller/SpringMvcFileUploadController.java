package com.gyb.controller;

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
     * description: TODO
     * create time: 2020/7/14 16:30
     *
     * @param
     * @return
     */
    @RequestMapping("fileUpload")
    public String fileUpload(HttpServletRequest request, MultipartFile upload) throws IOException {

        System.out.println("SpringMVC");


        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
//        获取上传文件的名称
        String filename = upload.getOriginalFilename();
//        把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
//        完成文件上传
        upload.transferTo(new File(path, filename));
        return "success";
    }
}
