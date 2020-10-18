package com.hy.csi.home.service.admin.entity;

import com.hy.csi.home.service.base.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value="FacekeyInf对象", description="")
public class FacekeyInf extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "百度语音合成所需要的appID")
    @TableField("appID")
    private String appID;

    @ApiModelProperty(value = "百度语音合成所需要的apiKey")
    @TableField("apiKey")
    private String apiKey;

    @ApiModelProperty(value = "百度语音合成所需要的secretKey")
    @TableField("secretKey")
    private String secretKey;

    @ApiModelProperty(value = "人脸对比阀值threshold")
    private Integer threshold;

    @ApiModelProperty(value = "逻辑删除 1(true)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
