package com.hy.csi.home.service.admin.controller;


import com.hy.csi.home.service.admin.entity.DeptInf;
import com.hy.csi.home.service.admin.entity.JobInf;
import com.hy.csi.home.service.admin.entity.NoticeInf;
import com.hy.csi.home.service.admin.service.JobInfService;
import com.hy.csi.home.service.admin.service.NoticeInfService;
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
@Api(tags = "职位管理")
@RestController
@RequestMapping("/admin/job-inf")
public class JobInfController {
    @Autowired
    private JobInfService jobInfService;

    @ApiOperation(value = "所有职位列表")
    @GetMapping("list")
    public R listAll(){
        return R.ok().data("items", jobInfService.list()).message("成功获取");
    }

    @ApiOperation("新增职位")
    @PostMapping("save")
    public R save(@ApiParam(value = "职位", required = true) @RequestBody JobInf jobInf){
        boolean result = jobInfService.save(jobInf);
        return result ? R.ok().message("保存成功") : R.error().message("保存失败");
    }

    @ApiOperation(value = "根据ID删除职位", notes = "根据ID逻辑删除职位")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam("职位ID") @PathVariable String id){
        boolean result = jobInfService.removeById(id);
        return result ? R.ok().message("删除成功") : R.error().message("删除失败");
    }

    @ApiOperation("更新职位")
    @PutMapping("update")
    public R updateById(@ApiParam(value = "职位", required = true) @RequestBody JobInf jobInf){
        boolean result = jobInfService.updateById(jobInf);
        return result ? R.ok().message("修改成功") : R.error().message("数据不存在");
    }
}

