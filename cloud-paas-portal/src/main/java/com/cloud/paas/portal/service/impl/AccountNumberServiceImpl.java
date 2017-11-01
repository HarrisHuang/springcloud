/**     
 * @FileName: AccountNumberServiceImpl.java   
 * @Package:com.cloud.paas.portal.service.impl   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月1日 下午2:48:41   
 */
package com.cloud.paas.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.paas.portal.domain.AccountNumber;
import com.cloud.paas.portal.domain.condition.AccountNumberCondition;
import com.cloud.paas.portal.persistence.AccountNumberMapper;
import com.cloud.paas.portal.service.AccountNumberService;

/**  
 * @ClassName: AccountNumberServiceImpl   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月1日 下午2:48:41     
 */
@Service("accountNumberService")
public class AccountNumberServiceImpl implements AccountNumberService {

	@Resource
	AccountNumberMapper accountNumberMapper;
	
	
	@Override
	public List<AccountNumber> list(AccountNumberCondition accountNumberCondition) {
		return accountNumberMapper.list(accountNumberCondition);
	}

	@Override
	public AccountNumber get(String accountNumberId) {
		return accountNumberMapper.get(accountNumberId);
	}

	@Override
	public AccountNumber getAccountNumberByLoginName(AccountNumberCondition accountNumberCondition) {
		return accountNumberMapper.getAccountNumberByLoginName(accountNumberCondition);
	}

}
