package com.hy.csi.home.service.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.csi.home.service.admin.entity.vo.UserQueryVo;
import com.hy.csi.home.service.base.result.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.csi.home.service.admin.entity.UserInf;
import com.hy.csi.home.service.admin.service.UserInfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author gyf
 * @since 2020-10-18
 */
@CrossOrigin
@Api(tags = "人员信息管理")
@RestController
@RequestMapping("/admin/user-inf")
public class UserInfController {

    @Autowired
    private UserInfService userInfService;

    @ApiOperation(value = "所有人员列表")
    @GetMapping("list")
    public R listAll(){
        return R.ok().data("items", userInfService.list()).message("成功获取");
    }

    @ApiOperation(value = "根据ID删除人员", notes = "根据ID逻辑删除人员")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam("人员ID") @PathVariable String id){
        boolean result = userInfService.removeById(id);
        return result ? R.ok().message("删除成功") : R.error().message("删除失败");
    }

    @ApiOperation("分页人员列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("讲师列表查询对象") UserQueryVo userQueryVo){
        Page<UserInf> pageParam = new Page<>(page, limit);
        IPage<UserInf> pageModel = userInfService.selectPage(page,limit, userQueryVo);
        List<UserInf> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        // total是数据总数，rows是当前分页的记录数
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
    public R save(@ApiParam(value = "用户对象", required = true) @RequestBody UserInf userInf){
        boolean result = userInfService.save(userInf);
        return result ? R.ok().message("保存成功") : R.error().message("保存失败");
    }

    @ApiOperation("更新用户")
    @PutMapping("update")
    public R updateById(@ApiParam(value = "用户对象", required = true) @RequestBody UserInf userInf){
        boolean result = userInfService.updateById(userInf);
        return result ? R.ok().message("修改成功") : R.error().message("数据不存在");
    }

    @ApiOperation("根据ID获取用户")
    @GetMapping("get/{id}")
    public R updateById(@ApiParam("用户对象") @PathVariable String id){
        UserInf userInf = userInfService.getById(id);
        return userInf!=null ? R.ok().data("item",userInf) : R.error().message("数据不存在");
    }

}

