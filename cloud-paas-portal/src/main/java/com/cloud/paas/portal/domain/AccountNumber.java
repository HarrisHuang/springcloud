/**     
 * @FileName: AccountNumber.java   
 * @Package:com.cloud.paas.portal.domain   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月1日 上午11:41:35   
 */
package com.cloud.paas.portal.domain;

import java.io.Serializable;

import com.bzwframework.persistencelayer.mybatis.annotation.Column;
import com.bzwframework.persistencelayer.mybatis.annotation.Table;

/**  
 * @ClassName: AccountNumber   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月1日 上午11:41:35     
 */
@Table(name = "TPT_ACCOUNT_NUMBER")
public class AccountNumber implements Serializable{

	@Column(isPrimaryKey = true, generatedPrimaryKey32UUID = true)
    private String accountNumberId;

	/**
     * <pre>
     * 登录名
     * 表字段 : TPT_ACCOUNT_NUMBER.LOGIN_NAME
     * </pre>
     */
    private String loginName;

    /**
     * <pre>
     * 登录密码
     * 表字段 : TPT_ACCOUNT_NUMBER.LOGIN_PASSWORD
     * </pre>
     */
    private String loginPassword;

    /**
     * <pre>
     * 状态
     * 表字段 : TPT_ACCOUNT_NUMBER.STATUS
     * </pre>
     */
    private String status;

    /**
     * <pre>
     * 姓名
     * 表字段 : TPT_ACCOUNT_NUMBER.NAME
     * </pre>
     */
    private String name;

    /**
     * <pre>
     * 手机号码
     * 表字段 : TPT_ACCOUNT_NUMBER.MOBILE_NUMBER
     * </pre>
     */
    private String mobileNumber;


    /**
     * <pre>
     * 排序号码
     * 表字段 : TPT_ACCOUNT_NUMBER.SORT_NUMBER
     * </pre>
     */
    private Short sortNumber;
    
    /**
     * 头像
     */
    private String avatar;

	/* (non-Javadoc)   
	 * @return   
	 * @see java.lang.Object#toString()   
	 */  
	@Override
	public String toString() {
		return "AccountNumber [accountNumberId=" + accountNumberId + ", loginName=" + loginName + ", loginPassword="
				+ loginPassword + ", status=" + status + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", sortNumber=" + sortNumber + ", avatar=" + avatar + "]";
	}

	/**   
	 * @return accountNumberId   
	 */
	public String getAccountNumberId() {
		return accountNumberId;
	}

	/**     
	 * @param accountNumberId the accountNumberId to set     
	 */
	public void setAccountNumberId(String accountNumberId) {
		this.accountNumberId = accountNumberId;
	}

	/**   
	 * @return loginName   
	 */
	public String getLoginName() {
		return loginName;
	}

	/**     
	 * @param loginName the loginName to set     
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**   
	 * @return loginPassword   
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**     
	 * @param loginPassword the loginPassword to set     
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**   
	 * @return status   
	 */
	public String getStatus() {
		return status;
	}

	/**     
	 * @param status the status to set     
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**   
	 * @return name   
	 */
	public String getName() {
		return name;
	}

	/**     
	 * @param name the name to set     
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**   
	 * @return mobileNumber   
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**     
	 * @param mobileNumber the mobileNumber to set     
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**   
	 * @return sortNumber   
	 */
	public Short getSortNumber() {
		return sortNumber;
	}

	/**     
	 * @param sortNumber the sortNumber to set     
	 */
	public void setSortNumber(Short sortNumber) {
		this.sortNumber = sortNumber;
	}

	/**   
	 * @return avatar   
	 */
	public String getAvatar() {
		return avatar;
	}

	/**     
	 * @param avatar the avatar to set     
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
    
    
    
    
}
