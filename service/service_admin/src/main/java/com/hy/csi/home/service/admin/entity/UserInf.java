package com.hy.csi.home.service.admin.entity;

import com.hy.csi.home.service.base.model.BaseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gyf
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UserInf对象", description="")
public class UserInf extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "登录名")
    private String loginname;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "权限状态 1管理员，2用户")
    private Integer status;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "注册人脸图片访问")
    private String faceurl;

    @ApiModelProperty(value = "注册人脸图片存储路径")
    private String facepath;


}
