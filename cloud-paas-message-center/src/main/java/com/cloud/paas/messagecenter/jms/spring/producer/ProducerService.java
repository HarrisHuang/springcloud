/**     
 * @FileName: ProducerService.java   
 * @Package:com.cloud.paas.messagecenter.jms.spring.producer   
 * @Description: TODO  
 * @author: huangyan    
 * @date:2017年9月3日 上午2:58:17   
 */
package com.cloud.paas.messagecenter.jms.spring.producer;

/**  
 * @ClassName: ProducerService   
 * @Description: TODO  
 * @author: huangyan  
 * @date:2017年9月3日 上午2:58:17     
 */
public interface ProducerService {

	void sendMessage(String message);
}
