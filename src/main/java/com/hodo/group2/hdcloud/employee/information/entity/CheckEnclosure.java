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
 * @date 2020-07-31 17:16:48
 */
@Data
@TableName("check_enclosure")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class CheckEnclosure extends Model<CheckEnclosure> {
private static final long serialVersionUID = 1L;

    /**
     * 学位证
     */
    @ApiModelProperty(value="学位证")
    private String academicDegree;
    /**
     * 毕业证
     */
    @ApiModelProperty(value="毕业证")
    private String diploma;
    /**
     * 学位证原图
     */
    @ApiModelProperty(value="学位证原图")
    private String academicDegreeOrig;
    /**
     * 毕业证原图
     */
    @ApiModelProperty(value="毕业证原图")
    private String diplomaOrig;
    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private String id;
    /**
     * 其他证件
     */
    @ApiModelProperty(value="其他证件")
    private String otherCertificate;
    /**
     * 其他证件原图
     */
    @ApiModelProperty(value="其他证件原图")
    private String otherCertificateOrig;
    /**
     * 基础表id
     */
    @ApiModelProperty(value="基础表id")
    private String baseId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String crtUserName;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String crtUserId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime crtTime;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String deptId;
    /**
     * 
     */
    @ApiModelProperty(value="",hidden=true)
    private String tenantId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String updUserName;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String updUserId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime updTime;
    /**
     * 身份证正面
     */
    @ApiModelProperty(value="身份证正面")
    private String idCardPhoto;
    /**
     * 身份证背面
     */
    @ApiModelProperty(value="身份证背面")
    private String idCardPhotoBack;
    /**
     * 身份证正面原图
     */
    @ApiModelProperty(value="身份证正面原图")
    private String idCardPhotoOrig;
    /**
     * 身份证背面原图
     */
    @ApiModelProperty(value="身份证背面原图")
    private String idCardPhotoBackOrig;
    /**
     * 体检报告
     */
    @ApiModelProperty(value="体检报告")
    private String examinationReport;
    /**
     * 体检报告原图
     */
    @ApiModelProperty(value="体检报告原图")
    private String examinationReportOrig;
    /**
     * 在校证明
     */
    @ApiModelProperty(value="在校证明")
    private String schoolCertificate;
    /**
     * 在校证明原图
     */
    @ApiModelProperty(value="在校证明原图")
    private String schoolCertificateOrig;
    /**
     * 银行卡原图
     */
    @ApiModelProperty(value="银行卡原图")
    private String bankCardOrig;
    /**
     * 银行卡
     */
    @ApiModelProperty(value="银行卡")
    private String bankCard;
    /**
     * 银行卡号
     */
    @ApiModelProperty(value="银行卡号")
    private String bankCardNum;
    /**
     * 开户行
     */
    @ApiModelProperty(value="开户行")
    private String bankOfDeposit;
    /**
     * 离职证明
     */
    @ApiModelProperty(value="离职证明")
    private String leavingCertificate;
    /**
     * 离职证明原图
     */
    @ApiModelProperty(value="离职证明原图")
    private String leavingCertificateOrig;
    /**
     * 2寸免冠照片
     */
    @ApiModelProperty(value="2寸免冠照片")
    private String twoInchesPhoto;
    /**
     * 2寸免冠照片原图
     */
    @ApiModelProperty(value="2寸免冠照片原图")
    private String twoInchesPhotoOrig;
    }
