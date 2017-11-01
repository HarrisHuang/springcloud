/**     
 * @FileName: AccountNumberMapper.java   
 * @Package:com.cloud.paas.portal.persistence   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月1日 下午2:50:11   
 */
package com.cloud.paas.portal.persistence;

import java.util.List;

import com.bzwframework.persistencelayer.mybatis.BaseMapper;
import com.cloud.paas.portal.domain.AccountNumber;
import com.cloud.paas.portal.domain.condition.AccountNumberCondition;

/**  
 * @ClassName: AccountNumberMapper   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月1日 下午2:50:11     
 */
public interface AccountNumberMapper extends BaseMapper<AccountNumber>{
	
	/**
	 * 
	 * @Title: list   
	 * @Description: 查询账户列表信息  
	 * @param accountNumberCondition
	 * @return  List<AccountNumber>
	 */
	List<AccountNumber> list(AccountNumberCondition accountNumberCondition);

	/**
	 * 
	 * @Title: get   
	 * @Description: 通过账户id查询账户信息  
	 * @param accountNumberId
	 * @return AccountNumber
	 */
	AccountNumber get(String accountNumberId);

	/**
	 * 
	 * @Title: getAccountNumberByLoginName   
	 * @Description: 通过登录名查询账户信息  
	 * @param accountNumberCondition
	 * @return AccountNumber
	 */
	AccountNumber getAccountNumberByLoginName(AccountNumberCondition accountNumberCondition);

}
