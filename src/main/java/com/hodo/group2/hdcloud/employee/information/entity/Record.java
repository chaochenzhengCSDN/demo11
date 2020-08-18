/*
 *    Copyright (c) 2018-2025, hodo All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: 江苏红豆工业互联网有限公司
 */

package com.hodo.group2.hdcloud.employee.information.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 
 *
 * @author zxw
 * @date 2020-07-31 17:16:49
 */
@Data
@TableName("record")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Record extends Model<Record> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private String id;
    /**
     * 红豆id
     */
    @ApiModelProperty(value="红豆id")
    private String hdId;
    /**
     * 操作类型 1审核变更 2自行变更 3状态变更
     */
    @ApiModelProperty(value="操作类型 1审核变更 2自行变更 3状态变更")
    private String operationType;
    /**
     * 操作详情
     */
    @ApiModelProperty(value="操作详情")
    private String content;
    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String crtUserName;
    /**
     * 创建人id
     */
    @ApiModelProperty(value="创建人id")
    private String crtUserId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime crtTime;
    /**
     * 部门id
     */
    @ApiModelProperty(value="部门id")
    private String deptId;
    /**
     * 租户id
     */
    @ApiModelProperty(value="租户id",hidden=true)
    private String tenantId;
    /**
     * 更新人
     */
    @ApiModelProperty(value="更新人")
    private String updUserName;
    /**
     * 更新人id
     */
    @ApiModelProperty(value="更新人id")
    private String updUserId;
    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updTime;
    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;
    /**
     * base_id
     */
    @ApiModelProperty(value="base_id")
    private String baseId;
    }
