package com.ynu.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class FileUpload {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    public static String upload(String fileName){
        System.out.println(fileName);
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI6kKkQLrLuux0";
        String accessKeySecret = "FbjVYOa9wuil6ChO8eAKysY4CXDedA";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传字符串。
//        String content = "Hello SongChenming";
        File localFile = new File(fileName);
        String name = "csi/" + localFile.getName();
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        PutObjectResult putObjectResult = ossClient.putObject("cmfighting", name, localFile);
        String uri = "https://cmfighting.oss-cn-shenzhen.aliyuncs.com/"+name;
        ossClient.shutdown();
        return uri;
    }
}
