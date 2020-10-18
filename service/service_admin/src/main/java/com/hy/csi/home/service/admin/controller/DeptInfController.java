package com.hy.csi.home.service.admin.controller;


import com.hy.csi.home.service.admin.entity.DeptInf;
import com.hy.csi.home.service.admin.entity.JobInf;
import com.hy.csi.home.service.admin.entity.UserInf;
import com.hy.csi.home.service.admin.service.DeptInfService;
import com.hy.csi.home.service.admin.service.JobInfService;
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
@Api(tags = "部门管理")
@RestController
@RequestMapping("/admin/dept-inf")
public class DeptInfController {
    @Autowired
    private DeptInfService deptInfService;

    @ApiOperation(value = "所有部门列表")
    @GetMapping("list")
    public R listAll(){
        return R.ok().data("items", deptInfService.list()).message("成功获取");
    }

    @ApiOperation("新增部门")
    @PostMapping("save")
    public R save(@ApiParam(value = "部门", required = true) @RequestBody DeptInf deptInf){
        boolean result = deptInfService.save(deptInf);
        return result ? R.ok().message("保存成功") : R.error().message("保存失败");
    }

    @ApiOperation(value = "根据ID删除部门", notes = "根据ID逻辑删除部门")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam("部门ID") @PathVariable String id){
        boolean result = deptInfService.removeById(id);
        return result ? R.ok().message("删除成功") : R.error().message("删除失败");
    }

    @ApiOperation("更新部门")
    @PutMapping("update")
    public R updateById(@ApiParam(value = "职位", required = true) @RequestBody DeptInf deptInf){
        boolean result = deptInfService.updateById(deptInf);
        return result ? R.ok().message("修改成功") : R.error().message("数据不存在");
    }
}

