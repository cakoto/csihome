package com.hy.csi.home.service.admin.entity;

import java.util.Date;
import com.hy.csi.home.service.base.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="EmployeeInf对象", description="")
public class EmployeeInf extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "部门")
    @TableField("dept_Id")
    private Integer deptId;

    @ApiModelProperty(value = "职位")
    private Integer jobId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证")
    private String cardId;

    @ApiModelProperty(value = "住址")
    private String address;

    @ApiModelProperty(value = "邮编")
    private String postCode;

    @ApiModelProperty(value = "固定电话")
    private String tel;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "QQ号")
    private String qqNum;

    @ApiModelProperty(value = "电邮")
    private String email;

    @ApiModelProperty(value = "性别 1为男 2为女")
    private Integer sex;

    @ApiModelProperty(value = "政治面貌")
    private String patry;

    @ApiModelProperty(value = "民族")
    private String race;

    @ApiModelProperty(value = "教育程度")
    private String education;

    @ApiModelProperty(value = "特长")
    private String sprciality;

    @ApiModelProperty(value = "爱好")
    private String hobby;

    @ApiModelProperty(value = "备注")
    private String reamrk;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;


}
