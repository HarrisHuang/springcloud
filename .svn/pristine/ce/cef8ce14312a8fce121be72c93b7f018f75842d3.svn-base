/**     
 * @FileName: AuthenticateController.java   
 * @Package:com.cloud.paas.portal.controller   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月8日 上午10:03:19   
 */
package com.cloud.paas.portal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.paas.common.exception.CloudException;
import com.cloud.paas.common.util.ConstUtils;
import com.cloud.paas.portal.domain.AccountNumber;
import com.cloud.paas.portal.domain.condition.AccountNumberCondition;
import com.cloud.paas.portal.service.AccountNumberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**  
 * @ClassName: AuthenticateController   
 * @Description: 登录登出  
 * @author: huangyan  
 * @date:2017年9月8日 上午10:03:19     
 */
@RestController
@RequestMapping("auth")
@CrossOrigin
@Api(description = "账户验证接口")
public class AuthenticateController {
	
	@Resource(name = "redisTemplate")
	ValueOperations<String,Object> vOps;
	
	@Resource
	AccountNumberService accountNumberService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthenticateController.class);

	private static String[] SESSION_ARRAY = { ConstUtils.SESSION_USER_NAME, ConstUtils.SESSION_ACCOUNT_ID,
			ConstUtils.SESSION_ACCOUNT_NAME, ConstUtils.SESSION_USER_ID, ConstUtils.SESSION_ORGAN_ID,
			ConstUtils.SESSION_ORGAN_NAME, ConstUtils.SESSION_LOGIN_ENTRANCE, ConstUtils.VIEW_SHELL,
			ConstUtils.SESSION_ROLE_ID_LIST,ConstUtils.SESSION_AVATAR};
	
	@ApiOperation(value="账户登录验证接口",notes="根据登录名和登录密码，验证账户信息")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Map<String,Object> login(@RequestBody AccountNumberCondition accountNumberCondition, HttpSession session,HttpServletRequest request) {
		
		Map<String, Object> returnVal = new HashMap<String, Object>();
		
		try {
			AccountNumber accountNumber = accountNumberService.getAccountNumberByLoginName(accountNumberCondition);
			
			if(null == accountNumber) {
				throw new CloudException("无效的账号!");
			}
			
			if(accountNumberCondition.getLoginPassword() == null || "".equals(accountNumberCondition.getLoginPassword())) {
				throw new CloudException("用户密码为空!");
			}
			
			if(!accountNumberCondition.getLoginPassword().equals(accountNumber.getLoginPassword())) {
				throw new CloudException("用户名密码错误!");
			}
			
			session.setAttribute(ConstUtils.SESSION_ACCOUNT_ID, accountNumber.getAccountNumberId());
			session.setAttribute(ConstUtils.SESSION_ACCOUNT_NAME, accountNumber.getName());
			session.setAttribute("LOGIN_NAME", accountNumber.getLoginName());
			
			vOps.set("loginAccountNumber", accountNumber);
			
			for (int i = 0; i < 10; i++) {
				vOps.set("redis-test"+i, "redis_test"+i);
			}
			
			
			// 设置返回值
			returnVal.put("validResult", true);
		} catch (Exception e) {
			returnVal.put("validResult", "error");
			returnVal.put("message", "服务器内部错误"+e.getMessage());
			return returnVal;
		}
		
		return returnVal;
	}
	
}
