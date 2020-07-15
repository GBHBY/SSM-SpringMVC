package com.gyb.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @Author gb
 * @Date 2020/7/12 13:38
 * @Version 1.0
 * description:
 */
@Controller
@RequestMapping("file")
public class FileUploadController {


    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/12 13:47
     *
     * @param request
     * @return
     */
    @RequestMapping("fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {

        System.out.println("传统");


        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem item : fileItems) {
// 进行判断，当前item是否是上传文件项
            if (item.isFormField()) {
//                普通文件项
            } else {
//                上传文件项
//                获取上传文件的名字
                String fileName = item.getName();
//                将上传的文件设置成唯一值，防止重复上传覆盖
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
//                完成文件上传
                item.write(new File(path, fileName));
//                删除临时文件(当上传文件大于10KB，就会生成临时文件，如果小于10KB，临时文件会在内存中产生)
                item.delete();

            }

        }


        return "success";
    }
}
