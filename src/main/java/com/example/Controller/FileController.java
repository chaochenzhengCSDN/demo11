package com.example.Controller;

import jdk.nashorn.internal.ir.ReturnNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 * @author Administrator
 */
@RestController
public class FileController {
    private static final Logger log= LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        try {
            if(file.isEmpty()){
                return "file is empty";
            }
            //获取文件名称
            String fileName = file.getName();
            //文件后缀名
            String suffixName =fileName.substring(fileName.lastIndexOf("."));
            log.info("文件名称为:"+fileName+";文件后缀名:"+suffixName);
            //设置文件存储路径(F:\\)
            String filePath ="F:\\";
            //拼接文件路径
            String path =filePath +fileName ;
            File dest=new File(path);
            //检查是否存在目录
            if(!dest.getParentFile().exists()){
                //当前目录不存在，新建目录
                dest.getParentFile().mkdirs();
            }
            //文件写入
            file.transferTo(dest);
            return "upoad success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "upload failure";
    }
}
