package com.hy.csi.home.service.admin.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String logginname;
    private String username;
    private String password;
    private Integer status;
}
