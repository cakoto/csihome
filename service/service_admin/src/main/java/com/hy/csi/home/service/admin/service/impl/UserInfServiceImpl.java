package com.hy.csi.home.service.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.csi.home.service.admin.entity.UserInf;
import com.hy.csi.home.service.admin.entity.vo.UserQueryVo;
import com.hy.csi.home.service.admin.mapper.UserInfMapper;
import com.hy.csi.home.service.admin.service.UserInfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gyf
 * @since 2020-10-18
 */
@Service
public class UserInfServiceImpl extends ServiceImpl<UserInfMapper, UserInf> implements UserInfService {


    @Override
    public IPage<UserInf> selectPage(Long page, Long limit, UserQueryVo userQueryVo) {

        Page<UserInf> pageParam = new Page<>(page, limit);

        QueryWrapper<UserInf> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");

        if(userQueryVo == null) {
            return baseMapper.selectPage(pageParam,queryWrapper);
        }

        String logginname = userQueryVo.getLogginname();
        String username = userQueryVo.getUsername();
        Integer status = userQueryVo.getStatus();

        if(!StringUtils.isEmpty(logginname)) {
            queryWrapper.likeRight("logginname", logginname);
        }
        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}
