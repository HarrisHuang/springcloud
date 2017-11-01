/**     
 * @FileName: PermissionZuulPreFilter.java   
 * @Package:com.cloud.paas.apigateway.filter   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年8月29日 下午4:39:37   
 */
package com.cloud.paas.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**  
 * @ClassName: PermissionZuulPreFilter   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年8月29日 下午4:39:37     
 */
@Component
public class PermissionZuulPreFilter extends ZuulFilter {

	private final static Logger log = LoggerFactory.getLogger(PermissionZuulPreFilter.class);

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		
		RequestContext ctx = RequestContext.getCurrentContext();
		
		HttpServletRequest request = ctx.getRequest();
		String uri = request.getRequestURI();
        String preUri = uri.substring(1, uri.length());
        log.info("Permission filter :uri : " + uri);
        log.info("Permission filter :preUri : " + preUri);
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 是否执行该过滤器，此处为true，说明需要过滤
		return true;
	}

	@Override
	public int filterOrder() {
		// 优先级为0，数字越大，优先级越低
		return 0;
	}

	@Override
	public String filterType() {
		// 前置过滤器
		return "pre";
	}
	
	
	
}
