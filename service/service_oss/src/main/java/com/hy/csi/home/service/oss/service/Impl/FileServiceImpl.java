package com.hy.csi.home.service.oss.service.Impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.hy.csi.home.service.oss.service.FileService;
import com.hy.csi.home.service.oss.util.OssProperties;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private OssProperties ossProperties;


    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {
        // 配置读取信息
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();

        // 创建实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        //判断oss实例是否存在：如果不存在则创建，如果存在则获取
        if(!ossClient.doesBucketExist(bucketname)) {
            ossClient.createBucket(bucketname);
            // 设置oss实例的访问权限：公共读
            ossClient.setBucketAcl(bucketname, CannedAccessControlList.PublicRead);
        }

        // 构建日期路径：avatar/2020/08/30/default.jpg
        String folder = new DateTime().toString("yyyy/MM/dd");

        // 文件名
        String fileName = UUID.randomUUID().toString();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String key = module + "/" + folder + "/" + fileName + fileExtension;

        // 上传文件流
        ossClient.putObject(bucketname, key, inputStream);

        // 关闭OSS
        ossClient.shutdown();

        // 返回URL地址
        return "https://" + bucketname + "." + endpoint + "/" + key;
    }
}
