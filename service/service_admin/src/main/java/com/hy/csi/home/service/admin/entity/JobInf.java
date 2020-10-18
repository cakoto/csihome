package com.hy.csi.home.service.admin.entity;

import com.hy.csi.home.service.base.model.BaseEntity;
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
@ApiModel(value="JobInf对象", description="")
public class JobInf extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "职位名称")
    private String name;

    @ApiModelProperty(value = "详细信息")
    private String remark;


}
