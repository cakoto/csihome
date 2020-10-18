package com.hy.csi.home.service.oss.controller.admin;

import com.hy.csi.home.service.admin.entity.DocumentInf;
import com.hy.csi.home.service.admin.entity.UserInf;
import com.hy.csi.home.service.admin.service.DocumentInfService;
import com.hy.csi.home.service.base.result.R;
import com.hy.csi.home.service.oss.service.FileService;
import com.mysql.cj.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
@Api(tags = "阿里云文件管理")
@CrossOrigin
@RestController
@RequestMapping("/admin/oss/file")
@Slf4j
public class FileController {

    // @Autowired
    // private FileService fileService;
    // @Autowired
    // private DocumentInfService documentInfService;
    //
    // @ApiOperation("文件上传")
    // @PostMapping("upload")
    // public R uploadAndSave(
    //         @ApiParam(value = "文件", required = true)
    //         @RequestParam("file") MultipartFile file,
    //         @ApiParam(value = "模块", required = true)
    //         @RequestParam("module") String module) {
    //     String url = upload(file,module);
    //     return save(file,url);
    // }
    //
    //
    // public String upload(MultipartFile file,String module) {
    //
    //     InputStream inputStream = null;
    //     try {
    //         inputStream = file.getInputStream();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     String originalFilename = file.getOriginalFilename();
    //     String uploadUrl = fileService.upload(inputStream, module, originalFilename);
    //     return uploadUrl;
    //     // return R.ok().message("文件上传成功").data("url", uploadUrl);
    // }
    //
    // @ApiOperation("新增用户")
    // @PostMapping("save")
    // public R save(MultipartFile file,String url){
    //     DocumentInf documentInf = new DocumentInf();
    //     String originalFilename = file.getOriginalFilename();
    //     documentInf.setFilename(originalFilename);
    //     documentInf.setRemark("*");
    //     documentInf.setUrl(url);
    //     boolean result = documentInfService.save(documentInf);
    //     return result ? R.ok().message("上传成功") : R.error().message("数据库保存失败");
    // }

}
