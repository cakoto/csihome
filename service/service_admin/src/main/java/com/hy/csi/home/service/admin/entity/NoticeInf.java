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
@ApiModel(value="NoticeInf对象", description="")
public class NoticeInf extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "公告名称")
    private Integer title;

    @ApiModelProperty(value = "公告内容")
    private Integer content;

    @ApiModelProperty(value = "公告人")
    private Integer userId;


}
