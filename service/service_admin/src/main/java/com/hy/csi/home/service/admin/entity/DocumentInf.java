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
@ApiModel(value="DocumentInf对象", description="")
public class DocumentInf extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "文件名")
    private String filename;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "创建人ID")
    private Integer userId;

    @ApiModelProperty(value = "OSS上传后返回的地址")
    private String url;
}
