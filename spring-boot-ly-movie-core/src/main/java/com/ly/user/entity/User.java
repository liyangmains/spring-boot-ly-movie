package com.ly.user.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;


public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer signStatus;
    private String password;
    private String userAliase;
    private String userName;
    private Integer gender;
    private String headPic;
    private Date userBirthday;
    private Integer renzhengPhone;
    private Integer userType;
    private String userPhone;
    private String renzhengQq;
    private String userQq;
    private String userTelephone;
    private String userEMail;
    private String userAddress;
    private Integer certificateId;
    private String userCertificate;
    private String cardtyperemark;
    private String grantdept;
    private String cardaddress;
    private String userIdCard;
    private String nation;
    private Date userlifebegintime;
    private Date userlifeendtime;
    private Date userRegistered;
    private String certificateImage;
    private Integer certificateStatus;
    private Integer userLoginType;
    private String loginTypeNote;
    private Integer officePositionDataId;
    private Integer departmentId;
    private String gesturePassword;
    private Integer userBlacklist;
    private String note;
    private Integer inviteId;
    private Date createtime;
    private Date newtime;
    private Integer state;
    private Integer version;
    private Integer createid;
    
    private String bizNo;
    
	public String getBizNo() {
		return bizNo;
	}

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	
    public Integer getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(Integer signStatus) {
		this.signStatus = signStatus;
	}

	public Integer getCertificateStatus() {
		return certificateStatus;
	}

	public void setCertificateStatus(Integer certificateStatus) {
		this.certificateStatus = certificateStatus;
	}


	public Integer getUserBlacklist() {
		return userBlacklist;
	}

	public void setUserBlacklist(Integer userBlacklist) {
		this.userBlacklist = userBlacklist;
	}


	public User() {
		super();
	}

    
	

	public User(Integer id, Integer signStatus, String password, String userAliase, String userName, Integer gender,
			String headPic, Date userBirthday, Integer renzhengPhone, Integer userType, String userPhone,
			String renzhengQq, String userQq, String userTelephone, String userEMail, String userAddress,
			Integer certificateId, String userCertificate, String cardtyperemark, String grantdept, String cardaddress,
			String userIdCard, String nation, Date userlifebegintime, Date userlifeendtime, Date userRegistered,
			String certificateImage, Integer certificateStatus, Integer userLoginType, String loginTypeNote,
			Integer officePositionDataId, Integer departmentId, String gesturePassword, Integer userBlacklist,
			String note, Integer inviteId, Date createtime, Date newtime, Integer state, Integer version,
			Integer createid, String bizNo) {
		super();
		this.id = id;
		this.signStatus = signStatus;
		this.password = password;
		this.userAliase = userAliase;
		this.userName = userName;
		this.gender = gender;
		this.headPic = headPic;
		this.userBirthday = userBirthday;
		this.renzhengPhone = renzhengPhone;
		this.userType = userType;
		this.userPhone = userPhone;
		this.renzhengQq = renzhengQq;
		this.userQq = userQq;
		this.userTelephone = userTelephone;
		this.userEMail = userEMail;
		this.userAddress = userAddress;
		this.certificateId = certificateId;
		this.userCertificate = userCertificate;
		this.cardtyperemark = cardtyperemark;
		this.grantdept = grantdept;
		this.cardaddress = cardaddress;
		this.userIdCard = userIdCard;
		this.nation = nation;
		this.userlifebegintime = userlifebegintime;
		this.userlifeendtime = userlifeendtime;
		this.userRegistered = userRegistered;
		this.certificateImage = certificateImage;
		this.certificateStatus = certificateStatus;
		this.userLoginType = userLoginType;
		this.loginTypeNote = loginTypeNote;
		this.officePositionDataId = officePositionDataId;
		this.departmentId = departmentId;
		this.gesturePassword = gesturePassword;
		this.userBlacklist = userBlacklist;
		this.note = note;
		this.inviteId = inviteId;
		this.createtime = createtime;
		this.newtime = newtime;
		this.state = state;
		this.version = version;
		this.createid = createid;
		this.bizNo = bizNo;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	
    public String getPassword() {
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
    public String getUserAliase() {
		return userAliase;
	}
	
	public void setUserAliase(String userAliase){
		this.userAliase = userAliase;
	}
	
    public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
    public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender){
		this.gender = gender;
	}
	
    public String getHeadPic() {
		return headPic;
	}
	
	public void setHeadPic(String headPic){
		this.headPic = headPic;
	}
	
    public Date getUserBirthday() {
		return userBirthday;
	}
	
	public void setUserBirthday(Date userBirthday){
		this.userBirthday = userBirthday;
	}
	
    public Integer getRenzhengPhone() {
		return renzhengPhone;
	}
	
	public void setRenzhengPhone(Integer renzhengPhone){
		this.renzhengPhone = renzhengPhone;
	}
	
    public Integer getUserType() {
		return userType;
	}
	
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	
    public String getUserPhone() {
		return userPhone;
	}
	
	public void setUserPhone(String userPhone){
		this.userPhone = userPhone;
	}
	
    public String getRenzhengQq() {
		return renzhengQq;
	}
	
	public void setRenzhengQq(String renzhengQq){
		this.renzhengQq = renzhengQq;
	}
	
    public String getUserQq() {
		return userQq;
	}
	
	public void setUserQq(String userQq){
		this.userQq = userQq;
	}
	
    public String getUserTelephone() {
		return userTelephone;
	}
	
	public void setUserTelephone(String userTelephone){
		this.userTelephone = userTelephone;
	}
	
    public String getUserEMail() {
		return userEMail;
	}
	
	public void setUserEMail(String userEMail){
		this.userEMail = userEMail;
	}
	
    public String getUserAddress() {
		return userAddress;
	}
	
	public void setUserAddress(String userAddress){
		this.userAddress = userAddress;
	}
	
    public Integer getCertificateId() {
		return certificateId;
	}
	
	public void setCertificateId(Integer certificateId){
		this.certificateId = certificateId;
	}
	
    public String getUserCertificate() {
		return userCertificate;
	}
	
	public void setUserCertificate(String userCertificate){
		this.userCertificate = userCertificate;
	}
	
    public String getCardtyperemark() {
		return cardtyperemark;
	}
	
	public void setCardtyperemark(String cardtyperemark){
		this.cardtyperemark = cardtyperemark;
	}
	
    public String getGrantdept() {
		return grantdept;
	}
	
	public void setGrantdept(String grantdept){
		this.grantdept = grantdept;
	}
	
    public String getCardaddress() {
		return cardaddress;
	}
	
	public void setCardaddress(String cardaddress){
		this.cardaddress = cardaddress;
	}
	
    public String getUserIdCard() {
		return userIdCard;
	}
	
	public void setUserIdCard(String userIdCard){
		this.userIdCard = userIdCard;
	}
	
    public String getNation() {
		return nation;
	}
	
	public void setNation(String nation){
		this.nation = nation;
	}
	
    public Date getUserlifebegintime() {
		return userlifebegintime;
	}
	
	public void setUserlifebegintime(Date userlifebegintime){
		this.userlifebegintime = userlifebegintime;
	}
	
    public Date getUserlifeendtime() {
		return userlifeendtime;
	}
	
	public void setUserlifeendtime(Date userlifeendtime){
		this.userlifeendtime = userlifeendtime;
	}
	
    public Date getUserRegistered() {
		return userRegistered;
	}
	
	public void setUserRegistered(Date userRegistered){
		this.userRegistered = userRegistered;
	}
	
    public String getCertificateImage() {
		return certificateImage;
	}
	
	public void setCertificateImage(String certificateImage){
		this.certificateImage = certificateImage;
	}
	
    public Integer getUserLoginType() {
		return userLoginType;
	}
	
	public void setUserLoginType(Integer userLoginType){
		this.userLoginType = userLoginType;
	}
	
    public String getLoginTypeNote() {
		return loginTypeNote;
	}
	
	public void setLoginTypeNote(String loginTypeNote){
		this.loginTypeNote = loginTypeNote;
	}
	
    public Integer getOfficePositionDataId() {
		return officePositionDataId;
	}
	
	public void setOfficePositionDataId(Integer officePositionDataId){
		this.officePositionDataId = officePositionDataId;
	}
	
    public Integer getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(Integer departmentId){
		this.departmentId = departmentId;
	}
	
    public String getGesturePassword() {
		return gesturePassword;
	}
	
	public void setGesturePassword(String gesturePassword){
		this.gesturePassword = gesturePassword;
	}
	
    public String getNote() {
		return note;
	}
	
	public void setNote(String note){
		this.note = note;
	}
	
    public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
	}

	public Date getCreatetime() {
		return createtime;
	}
	
	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}
	
    public Date getNewtime() {
		return newtime;
	}
	
	public void setNewtime(Date newtime){
		this.newtime = newtime;
	}
	
    public Integer getState() {
		return state;
	}
	
	public void setState(Integer state){
		this.state = state;
	}
	
    public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version){
		this.version = version;
	}
	
    public Integer getCreateid() {
		return createid;
	}
	
	public void setCreateid(Integer createid){
		this.createid = createid;
	}
	
}