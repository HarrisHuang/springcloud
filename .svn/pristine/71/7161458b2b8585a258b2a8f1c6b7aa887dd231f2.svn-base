/**     
 * @FileName: AccountNumberController.java   
 * @Package:com.cloud.paas.portal.controller   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月1日 上午11:54:11   
 */
package com.cloud.paas.portal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.paas.common.controller.BaseController;
import com.cloud.paas.portal.domain.AccountNumber;
import com.cloud.paas.portal.domain.condition.AccountNumberCondition;
import com.cloud.paas.portal.service.AccountNumberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**  
 * @ClassName: AccountNumberController   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月1日 上午11:54:11     
 */
@RestController
@RequestMapping("account")
@CrossOrigin
@Api(description="账户接口")
public class AccountNumberController extends BaseController{
	
	@Resource
	AccountNumberService accountNumberService;
	
	@ApiOperation(value="查询账户列表信息",notes="查询不同的条件，查询出账户的列表信息")
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public Map<String,Object> list(@RequestBody AccountNumberCondition accountNumberCondition) {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("data", accountNumberService.list(accountNumberCondition));
		result.put("total", accountNumberCondition.getTotalRecord());
		
		return result;
	}
	
	@ApiOperation(value="查询单个账户信息",notes="根据账户id，查询出单个账户详细信息")
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public AccountNumber get(@RequestBody String accountNumberId) {
		return accountNumberService.get(accountNumberId);
	}
	
}
