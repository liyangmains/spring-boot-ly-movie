package com.ly.user.dto;

import java.util.Date;


import org.springframework.web.multipart.MultipartFile;

import com.ly.user.entity.User;


/**
 * Dto entity
 */
public class UserDto extends User {

	private Integer limit;

	private String orderByClause;
	
	private MultipartFile headPicFile;
	
	private MultipartFile[] certificateImageFile;
	
	
	private String oldPassword;
	
	private String oldPhone;
	
	private String newPhone;
	
	private String userNameLike;

	private String userPhoneLike;
	
	private String inviteUserPhone;
	
	private String userNamePhone;
	
	private Date beginDate;
	
	private Date endDate;
	
	private Integer activityId;

	//会员管理用户类型搜索 0 全部 1 正常账号 2马甲账号
	private Integer loginType;
	
	private Integer communityId;
	
	
	public Integer getLoginType() {
		return loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	public String getUserNamePhone() {
		return userNamePhone;
	}

	public void setUserNamePhone(String userNamePhone) {
		this.userNamePhone = userNamePhone;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getInviteUserPhone() {
		return inviteUserPhone;
	}

	public void setInviteUserPhone(String inviteUserPhone) {
		this.inviteUserPhone = inviteUserPhone;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUserNameLike() {
		return userNameLike;
	}

	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}
	

	public String getUserPhoneLike() {
		return userPhoneLike;
	}

	public void setUserPhoneLike(String userPhoneLike) {
		this.userPhoneLike = userPhoneLike;
	}

	public String getOldPhone() {
		return oldPhone;
	}

	public void setOldPhone(String oldPhone) {
		this.oldPhone = oldPhone;
	}

	public String getNewPhone() {
		return newPhone;
	}

	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public MultipartFile[] getCertificateImageFile() {
		return certificateImageFile;
	}

	public void setCertificateImageFile(MultipartFile[] certificateImageFile) {
		this.certificateImageFile = certificateImageFile;
	}

	public MultipartFile getHeadPicFile() {
		return headPicFile;
	}

	public void setHeadPicFile(MultipartFile headPicFile) {
		this.headPicFile = headPicFile;
	}


	public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    } 
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

}