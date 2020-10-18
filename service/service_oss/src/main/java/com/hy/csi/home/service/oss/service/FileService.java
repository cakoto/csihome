package com.hy.csi.home.service.oss.service;

import java.io.InputStream;

public interface FileService {
    // 上传的接口

    /**
     * 文件上传
     * @param inputStream       输入流
     * @param module            文件夹名称
     * @param originalFilename  原始文件名
     * @return 文件在oss服务器上的URL地址
     */
    String upload(InputStream inputStream, String module, String originalFilename);
}
