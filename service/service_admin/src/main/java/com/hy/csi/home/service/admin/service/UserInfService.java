package com.hy.csi.home.service.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.csi.home.service.admin.entity.UserInf;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.csi.home.service.admin.entity.vo.UserQueryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gyf
 * @since 2020-10-18
 */
public interface UserInfService extends IService<UserInf> {

    IPage<UserInf> selectPage(Long page, Long limit, UserQueryVo userQueryVo);

}
