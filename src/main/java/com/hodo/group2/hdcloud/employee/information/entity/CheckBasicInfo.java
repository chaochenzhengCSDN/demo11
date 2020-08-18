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
import java.math.BigDecimal;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author zxw
 * @date 2020-07-31 17:16:49
 */
@Data
@TableName("check_basic_info")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class CheckBasicInfo extends Model<CheckBasicInfo> {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private String id;
    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;
    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private String sex;
    /**
     * 应聘岗位
     */
    @ApiModelProperty(value="应聘岗位")
    private String jobApplication;
    /**
     * 出生年月
     */
    @ApiModelProperty(value="出生年月")
    private String birth;
    /**
     * 国籍
     */
    @ApiModelProperty(value="国籍")
    private String nationality;
    /**
     * 籍贯
     */
    @ApiModelProperty(value="籍贯")
    private String nativePlace;
    /**
     * 民族
     */
    @ApiModelProperty(value="民族")
    private String nation;
    /**
     * 政治面貌
     */
    @ApiModelProperty(value="政治面貌")
    private String politicalAffiliation;
    /**
     * 入党日期
     */
    @ApiModelProperty(value="入党日期")
    private String joiningPartyTime;
    /**
     * 服役情况
     */
    @ApiModelProperty(value="服役情况")
    private String activeService;
    /**
     * 身份证号
     */
    @ApiModelProperty(value="身份证号")
    private String idCard;
    /**
     * 部门id
     */
    @ApiModelProperty(value="部门id")
    private String deptId;
    /**
     * 是否有社保
     */
    @ApiModelProperty(value="是否有社保")
    private String socialSecurity;
    /**
     * 身高cm
     */
    @ApiModelProperty(value="身高cm")
    private String height;
    /**
     * 体重kg
     */
    @ApiModelProperty(value="体重kg")
    private String weight;
    /**
     * 学历
     */
    @ApiModelProperty(value="学历")
    private String education;
    /**
     * 专业
     */
    @ApiModelProperty(value="专业")
    private String specialities;
    /**
     * 职称
     */
    @ApiModelProperty(value="职称")
    private String professionalTitle;
    /**
     * 婚姻状况
     */
    @ApiModelProperty(value="婚姻状况")
    private String marriage;
    /**
     * 生育状况
     */
    @ApiModelProperty(value="生育状况")
    private String bear;
    /**
     * 本人手机
     */
    @ApiModelProperty(value="本人手机")
    private String oneselfPhone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String mail;
    /**
     * 紧急联络人
     */
    @ApiModelProperty(value="紧急联络人")
    private String emergencyContact;
    /**
     * 紧急联络人电话
     */
    @ApiModelProperty(value="紧急联络人电话")
    private String emergencyContactPhone;
    /**
     * 户籍地址
     */
    @ApiModelProperty(value="户籍地址")
    private String permanentAddress;
    /**
     * 详细户籍地址
     */
    @ApiModelProperty(value="详细户籍地址")
    private String permanentAddressDetils;
    /**
     * 家庭住址
     */
    @ApiModelProperty(value="家庭住址")
    private String homeAddress;
    /**
     * 详细家庭住址
     */
    @ApiModelProperty(value="详细家庭住址")
    private String homeAddressDetils;
    /**
     * 现居地址
     */
    @ApiModelProperty(value="现居地址")
    private String currentAddress;
    /**
     * 详细现居地址
     */
    @ApiModelProperty(value="详细现居地址")
    private String currentAddressDetils;
    /**
     * 计算机等级
     */
    @ApiModelProperty(value="计算机等级")
    private String computerLevel;
    /**
     * 办公软件技能
     */
    @ApiModelProperty(value="办公软件技能")
    private String softwares;
    /**
     * 英语等级
     */
    @ApiModelProperty(value="英语等级")
    private String englishLevel;
    /**
     * 何种渠道获取招聘信息
     */
    @ApiModelProperty(value="何种渠道获取招聘信息")
    private String channelFind;
    /**
     * 介绍人
     */
    @ApiModelProperty(value="介绍人")
    private String introducer;
    /**
     * 期望薪水
     */
    @ApiModelProperty(value="期望薪水")
    private BigDecimal expectedSalary;
    /**
     * 红豆id
     */
    @ApiModelProperty(value="红豆id")
    private String hdId;
    /**
     * 入职状态
     */
    @ApiModelProperty(value="入职状态")
    private String entryStatus;
    /**
     * 基础信息表id
     */
    @ApiModelProperty(value="基础信息表id")
    private String baseId;
    /**
     * 租户id
     */
    @ApiModelProperty(value="租户id",hidden=true)
    private String tenantId;
    /**
     * 微信openid
     */
    @ApiModelProperty(value="微信openid")
    private String openId;
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
     * 审核状态
     */
    @ApiModelProperty(value="审核状态")
    private String basicStatus;
    /**
     * 招聘流程状态
     */
    @ApiModelProperty(value="招聘流程状态")
    private String basicRecruitStatus;
    /**
     * 人才库状态
     */
    @ApiModelProperty(value="人才库状态")
    private String basicPersonnelStatus;
    /**
     * 招聘时间
     */
    @ApiModelProperty(value="招聘时间")
    private LocalDateTime recruitTime;
    /**
     * 入职时间
     */
    @ApiModelProperty(value="入职时间")
    private LocalDateTime entryTime;
    /**
     * 招聘表id
     */
    @ApiModelProperty(value="招聘表id")
    private Integer recruitId;
    /**
     * 招聘渠道
     */
    @ApiModelProperty(value="招聘渠道")
    private String recruitChannel;
    /**
     * 应聘岗位
     */
    @ApiModelProperty(value="应聘岗位")
    private String recruitJob;
    /**
     * 通知面试时间
     */
    @ApiModelProperty(value="通知面试时间")
    private LocalDateTime interviewTime;
    /**
     * 面试通知标记
     */
    @ApiModelProperty(value="面试通知标记")
    private String interviewFlag;
    /**
     * 面试备注
     */
    @ApiModelProperty(value="面试备注")
    private String interviewRemark;
    /**
     * 发offer时间
     */
    @ApiModelProperty(value="发offer时间")
    private LocalDateTime offerTime;
    /**
     * 发offer标记
     */
    @ApiModelProperty(value="发offer标记")
    private String offerFlag;
    /**
     * 发offer备注
     */
    @ApiModelProperty(value="发offer备注")
    private String offerRemark;
    }
