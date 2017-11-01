package com.cloud.paas.common.exception;

/**  
 * @ClassName: CloudException   
 * @Description: Cloud异常类  
 * @author: xiaodong.a.liu
 * @date:2017年6月5日 下午6:05:08     
 */ 
public class CloudException extends RuntimeException {

	/**   
	 * @Fields: serialVersionUID  
	 * @Todo: TODO  
	 */ 
	private static final long serialVersionUID = 1L;

	/**  
	 *    
	 */
	public CloudException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**  
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace   
	 */
	public CloudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**  
	 * @param message
	 * @param cause   
	 */
	public CloudException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**  
	 * @param message   
	 */
	public CloudException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**  
	 * @param cause   
	 */
	public CloudException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	/**   
	 * @Title: throwCloudException   
	 * @Description: TODO  
	 * @param message
	 * @param ex
	 */
	public static void throwCloudException(String message){
		throw new CloudException(message);
	}
	
	
	/**   
	 * @Title: throwCloudException   
	 * @Description: TODO  
	 * @param message
	 * @param e
	 */
	public static void throwCloudException(String message,Exception e){
		throw new CloudException(message,e);
	}

}
