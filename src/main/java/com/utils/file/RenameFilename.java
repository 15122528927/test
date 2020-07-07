package com.utils.file;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


//修改文件名称
@Component
public class RenameFilename {


    public static MultipartFile fileUpload(MultipartFile file  , String newName) {

        String path = System.getProperty("user.dir");

        if (file.isEmpty()) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(path + "/file/" + newName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest); // 保存文件
            File destNew =  new File(path + "/file/" + newName); //新的文件
            File destNew2 =  new File(path + "/file/" + newName); //新的文件

            //fiel 转 MultipartFile
            InputStream inputStream = new FileInputStream(destNew);
            MultipartFile multipartFile =   FileToMultipartFileUtil.toMultipartFile( destNew.getName() ,destNew);
            destNew2.delete(); //删除本地测试文件
            return multipartFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}





