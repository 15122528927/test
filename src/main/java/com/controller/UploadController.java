package com.controller;


import com.utils.file.RenameFilename;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadController {





    /**
     *
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @PostMapping("springUpload")
    public String springUpload(HttpServletRequest request)
            throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        // 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            // 将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {

                // 一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next()
                        .toString());
                if (file != null) {
                    System.out.print(file.getOriginalFilename());
                    String path = "E:/springUpload"
                            + file.getOriginalFilename();
                    // 上传
                    file.transferTo(new File(path));
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Spring方法的运行时间"
                + String.valueOf(endTime - startTime) + "ms");
        return "/success";
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @PostMapping("fileUpload")
    public String fileUpload2(@RequestParam("file") MultipartFile file
            , HttpServletRequest request)
            throws IOException {
        long startTime = System.currentTimeMillis();

        Enumeration<String> strs = request.getParameterNames();


        System.out.println("fileName ；" + file.getOriginalFilename());
        String path = "E:/" + new Date().getTime() + file.getOriginalFilename();

        File newFile = new File(path);
        // 通过CommonsMultipartFile的方法直接写文件（注意这个时候
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        System.out.println("采用file.Transto的运行时间："
                + String.valueOf(endTime - startTime) + "ms");
        return "/success____________________________________________________";
    }

    /**
     *
     * @param file 采用file.Transto 来保存上传的文件
     * @return
     * @throws IOException
     */
    @PostMapping("fileUploadCommonsMultipartFile")
    public String fileUploadCommonsMultipartFile(
            @RequestParam("file") CommonsMultipartFile file) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("fileName ；" + file.getOriginalFilename());
        String path = "E:/" + new Date().getTime() + file.getOriginalFilename();

        File newFile = new File(path);
        // 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        System.out.println("采用file.Transto的运行时间："
                + String.valueOf(endTime - startTime) + "ms");
        return "/success";
    }



    /*
     * 采用file.Transto 来保存上传的文件
     */
    @PostMapping("test")
    public String test(@RequestParam("file") MultipartFile file)
            throws Exception {
        file  = RenameFilename.fileUpload(file , "nacos132.zip");
        return file.getOriginalFilename();
    }


}
