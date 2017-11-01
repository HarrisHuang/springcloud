/**     
 * @FileName: AccountNumberControllerTest.java   
 * @Package:com.cloud.paas.portal.controller   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月1日 下午3:07:08   
 */
package com.cloud.paas.portal.controller;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cloud.paas.portal.PortalApplication;
import com.cloud.paas.portal.domain.AccountNumber;
import com.cloud.paas.portal.domain.condition.AccountNumberCondition;

/**  
 * @ClassName: AccountNumberControllerTest   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月1日 下午3:07:08     
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PortalApplication.class)
@WebAppConfiguration 
public class AccountNumberControllerTest {

	@Resource
	AccountNumberController accountNumberController;
	
	@Test
	public void getAccountNumberByLoginName() {
		String loginName = "admin";
		//AccountNumber accountNumber = accountNumberController
	}
	
	/**
	 * 
	 * @Title: listTest   
	 * @Description: 账号列表查询测试
	 */
	@Test
	public void listTest() {
		AccountNumberCondition accountNumberCondition = new AccountNumberCondition();
		Map<String,Object> result = null;
		result = accountNumberController.list(accountNumberCondition);
		
		List<AccountNumber> accountNumberList = (List<AccountNumber>) result.get("data");
		System.out.println("data:"+accountNumberList);
		assertTrue(accountNumberList != null);
		
		
	}
	
	/**
	 * 
	 * @Title: getTest   
	 * @Description: 单个账号查询测试
	 */
	@Test 
	public void getTest() {
		AccountNumber accountNumber = null;
		String accountNumberId = "1";
		accountNumber = accountNumberController.get(accountNumberId);
		System.out.println("get test data:"+accountNumber);
		assertTrue(accountNumber != null);
	}
	
}
