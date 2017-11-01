/**     
 * @FileName: AccountNumberService.java   
 * @Package:com.cloud.paas.portal.service   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月1日 下午2:47:34   
 */
package com.cloud.paas.portal.service;

import java.util.List;

import com.cloud.paas.portal.domain.AccountNumber;
import com.cloud.paas.portal.domain.condition.AccountNumberCondition;

/**  
 * @ClassName: AccountNumberService   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月1日 下午2:47:34     
 */
public interface AccountNumberService {

	/**
	 * 
	 * @Title: list   
	 * @Description: 查询账户列表信息  
	 * @param accountNumberCondition
	 * @return List<AccountNumber> 
	 */
	List<AccountNumber> list(AccountNumberCondition accountNumberCondition);

	/**
	 * 
	 * @Title: get   
	 * @Description: 根据账户id查询账户信息  
	 * @param accountNumberId
	 * @return AccountNumber
	 */
	AccountNumber get(String accountNumberId);

	/**
	 * 
	 * @Title: getAccountNumberByLoginName   
	 * @Description: 根据登录名称查询用户信息  
	 * @param accountNumberCondition
	 * @return AccountNumber
	 */
	AccountNumber getAccountNumberByLoginName(AccountNumberCondition accountNumberCondition);

	
}
