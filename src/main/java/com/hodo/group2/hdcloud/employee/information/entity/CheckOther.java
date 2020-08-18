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
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author zxw
 * @date 2020-07-31 17:16:49
 */
@Data
@TableName("check_other")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class CheckOther extends Model<CheckOther> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private String id;
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
     * 参加培训或教育情况
     */
    @ApiModelProperty(value="参加培训或教育情况")
    private String trainContent;
    /**
     * base_id
     */
    @ApiModelProperty(value="base_id")
    private String baseId;
    /**
     * 审核状态
     */
    @ApiModelProperty(value="审核状态")
    private String otherStatus;
    /**
     * 奖励或惩罚
     */
    @ApiModelProperty(value="奖励或惩罚")
    private String rewardsPunishmentsContent;
    /**
     * 专长
     */
    @ApiModelProperty(value="专长")
    private String expertiseContent;
    /**
     * 自我评价
     */
    @ApiModelProperty(value="自我评价")
    private String selfEvaluationContent;
    }
