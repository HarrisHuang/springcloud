/**     
 * @FileName: UserController.java   
 * @Package:com.cloud.paas.swagger.controller   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月13日 下午2:19:42   
 */
package com.cloud.paas.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**  
 * @ClassName: UserController   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月13日 下午2:19:42     
 */
@RestController
@Api(description = "用户接口")
@RequestMapping("user")
public class UserController {

	@ApiOperation(value="查询用户列表信息",notes="查询出所有的用户，以列表信息展现")
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	public String list(String name) {
		return "admin";
	}
	
	@ApiOperation(value="查询单个用户信息",notes="根据id,查询出相应的用户详细信息")
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public String get(String id) {
		return "user";
	}
}
