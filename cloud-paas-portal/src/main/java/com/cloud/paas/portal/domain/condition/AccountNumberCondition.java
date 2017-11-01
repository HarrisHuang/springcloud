/**     
 * @FileName: AccountNumberCondition.java   
 * @Package:com.cloud.paas.portal.domain.condition   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月1日 上午11:57:05   
 */
package com.cloud.paas.portal.domain.condition;

import java.util.List;

import com.bzwframework.persistencelayer.mybatis.PageQueryCondition;

/**  
 * @ClassName: AccountNumberCondition   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月1日 上午11:57:05     
 */
public class AccountNumberCondition extends PageQueryCondition{

	private String accountNumberId;
	private String loginName;//用户名
	private String loginPassword;//密码
	private String userType;
	private String loginEntrance;
	private List<String> viewShell;
	private String userId;//用户名
	
	private String name;// 账号名称
	private String status;//账号状态
	private String mobileNumber;
	
	
	/* (non-Javadoc)   
	 * @return   
	 * @see java.lang.Object#toString()   
	 */  
	@Override
	public String toString() {
		return "AccountNumberCondition [accountNumberId=" + accountNumberId + ", loginName=" + loginName
				+ ", loginPassword=" + loginPassword + ", userType=" + userType + ", loginEntrance=" + loginEntrance
				+ ", viewShell=" + viewShell + ", userId=" + userId + ", name=" + name + ", status=" + status
				+ ", mobileNumber=" + mobileNumber + "]";
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
	 * @return userType   
	 */
	public String getUserType() {
		return userType;
	}
	/**     
	 * @param userType the userType to set     
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**   
	 * @return loginEntrance   
	 */
	public String getLoginEntrance() {
		return loginEntrance;
	}
	/**     
	 * @param loginEntrance the loginEntrance to set     
	 */
	public void setLoginEntrance(String loginEntrance) {
		this.loginEntrance = loginEntrance;
	}
	/**   
	 * @return viewShell   
	 */
	public List<String> getViewShell() {
		return viewShell;
	}
	/**     
	 * @param viewShell the viewShell to set     
	 */
	public void setViewShell(List<String> viewShell) {
		this.viewShell = viewShell;
	}
	/**   
	 * @return userId   
	 */
	public String getUserId() {
		return userId;
	}
	/**     
	 * @param userId the userId to set     
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	
	
}
