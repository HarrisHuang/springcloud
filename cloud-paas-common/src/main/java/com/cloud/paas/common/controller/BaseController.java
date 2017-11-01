package com.cloud.paas.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cloud.paas.common.util.ConstUtils;



/**
 * @ClassName: BaseController
 * @Package com.accenture.javis.controller
 * @Description: Controller基础抽象类，�?有Controller类从此类继承。继承此类的子类的所有方法均可以从Model中获取到Session参数
 * @author zhengwei.bu
 * @date 2014�?3�?7�? 下午2:45:52
 */
@SessionAttributes(
		value={
			ConstUtils.SESSION_ACCOUNT_ID
			,ConstUtils.SESSION_ACCOUNT_NAME
			,ConstUtils.SESSION_USER_ID
			,ConstUtils.SESSION_USER_NAME
			,ConstUtils.SESSION_ORGAN_ID
			,ConstUtils.SESSION_ORGAN_NAME
			,ConstUtils.SESSION_LOGIN_ENTRANCE
			,ConstUtils.VIEW_SHELL
			,ConstUtils.SESSION_ROLE_ID_LIST
		}
	)
public abstract class BaseController {
	private final static Logger log = LoggerFactory.getLogger(BaseController.class);

	/**
	 * @Title: exceptionHandler
	 * @Description: 捕获�?有Controller（继承BaseController）的异常，并进行处理
	 * @param exception 异常
	 * @param request 请求
	 * @param response 应答
	 * @return Ajax调用返回错误信息；页面请求返回错误页�?
	 */
	@ExceptionHandler
	public String exceptionHandler(Exception exception,HttpServletRequest request,HttpServletResponse response){

		String infoMessage="很抱歉，服务器发生错误！";
		String errorId=UUID.randomUUID().toString().replace("-", "");
		StringBuilder errorMessage=new StringBuilder();
		errorMessage.append(exception.toString());
        StackTraceElement[] trace = exception.getStackTrace();
        if (trace!=null && trace[0]!=null){    
        	//不可以使�? \t制表�?,\n换行�? 等，否则前台不能正确得到JSON格式数据
        	errorMessage.append("    at " + trace[0].toString());	
        }
		log.error(errorId+"--"+exception.getMessage(),exception);
		if(request.getHeader("accept").indexOf("application/json")>-1
				|| request.getHeader("X-Requested-With")!=null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest")>-1
				|| request.getContentType()!=null && (request.getContentType().indexOf("multipart/form-data")>-1 || request.getContentType().indexOf("application/json")>-1)
		){
			try {
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				PrintWriter writer= response.getWriter();
				StringBuffer reMsg = new StringBuffer("");
				reMsg.append("{\"errorCode\":").append("\""+ConstUtils.ERROR_SYSTEM_EXCEPTION+"\"")
					  .append(",\"infoMessage\":").append("\""+infoMessage+"\"")
					  .append(",\"exceptionName\":").append("\""
							 +exception.getClass().toString()
							 	.replace("\"", "'")
							 	.replace('\t', ' ')
							 	.replace('\n', ' ')
							 +"\"")
					 .append(",\"exceptionMessage\":").append("\""
							 +((exception.getMessage()==null)?"Null Pointer Exception":exception.getMessage())
							 	.replace("\"", "'")
							 	.replace('\t', ' ')
							 	.replace('\n', ' ')
							 +"\"")
					 .append(",\"exceptionDetail\":")
					 .append("\""
					 				+errorMessage.toString()
					 				.replaceAll("[\\t\\n\\r]", " ").replaceAll("[\\\"]", "\\'")
							 +"\"")
					 .append("}");
				writer.print(reMsg.toString().replaceAll("[\\t\\n\\r]", " "));
				//writer.write("{\"errorCode\":\""+SystemConst.ERROR_SYSTEM_EXCEPTION+"\",\"infoMessage\":\""+infoMessage+"\",\"errorId\":\""+errorId+"\",\"errorMessage\":\""+errorMessage.toString().replace("\"", "'")+"\"}");
				writer.flush();
			} catch (IOException e) {
				log.error("捕获Ajax调用异常后，将错误信息返回给页面时出错！"+exception.getMessage(),exception);
			}
			return null;
		}else{
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			request.setAttribute("errorCode", ConstUtils.ERROR_SYSTEM_EXCEPTION);
			request.setAttribute("infoMessage", infoMessage);
			request.setAttribute("errorId", errorId);
			request.setAttribute("errorMessage", errorMessage);
			return "error/500";
		}
	}

}
