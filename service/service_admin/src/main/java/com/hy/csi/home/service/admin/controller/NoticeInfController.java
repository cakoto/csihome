package com.hy.csi.home.service.admin.controller;


import com.hy.csi.home.service.admin.entity.NoticeInf;
import com.hy.csi.home.service.admin.entity.UserInf;
import com.hy.csi.home.service.admin.service.NoticeInfService;
import com.hy.csi.home.service.admin.service.UserInfService;
import com.hy.csi.home.service.base.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gyf
 * @since 2020-10-18
 */
@CrossOrigin
@Api(tags = "公告管理")
@RestController
@RequestMapping("/admin/notice-inf")
public class NoticeInfController {

    @Autowired
    private NoticeInfService noticeInfService;

    @ApiOperation(value = "所有公告列表")
    @GetMapping("list")
    public R listAll(){
        return R.ok().data("items", noticeInfService.list()).message("成功获取");
    }

    @ApiOperation("新增公告")
    @PostMapping("save")
    public R save(@ApiParam(value = "公告", required = true) @RequestBody NoticeInf noticeInf){
        boolean result = noticeInfService.save(noticeInf);
        return result ? R.ok().message("保存成功") : R.error().message("保存失败");
    }

    @ApiOperation(value = "根据ID删除公告", notes = "根据ID逻辑删除公告")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam("公告ID") @PathVariable String id){
        boolean result = noticeInfService.removeById(id);
        return result ? R.ok().message("删除成功") : R.error().message("删除失败");
    }

}

