package com.cloud.paas.common.configuration;


import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

import com.cloud.paas.common.exception.CloudException;

import redis.clients.jedis.JedisPoolConfig;


/**
 * redis配置文件
 * 必须有 @EnableRedisHttpSession 否则 分布式Session不起作用
 * @author qiraosky
 *
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=4*60*60)
public class RedisConfig {
 
	private final static Logger log = LoggerFactory.getLogger(RedisConfig.class);
	
	@Resource
	Environment env;
 
	/**   
	 * @Title: getRedisHttpSessionConfiguration   
	 * @Description: TODO  
	 * @return RedisHttpSessionConfiguration
	 */
	@Bean
	public RedisHttpSessionConfiguration getRedisHttpSessionConfiguration(){
		RedisHttpSessionConfiguration rhsc = new RedisHttpSessionConfiguration();
		rhsc.setMaxInactiveIntervalInSeconds(600);
		return rhsc;
	}
	
	/**   
	 * @Title: getJedisPoolConfig   
	 * @Description: TODO  
	 * @return JedisPoolConfig
	 */
	@Bean(name="poolConfig")
	public JedisPoolConfig getJedisPoolConfig(){
		return new JedisPoolConfig();
	}
	
	/**   
	 * @Title: getRedisTemplate   
	 * @Description: TODO  
	 * @param connectionFactory
	 * @return getRedisTemplate
	 */
	@SuppressWarnings("rawtypes")
	@Bean(name="redisTemplate")
	public RedisTemplate getRedisTemplate(JedisConnectionFactory connectionFactory){
		RedisTemplate rt = new RedisTemplate();
		rt.setConnectionFactory(connectionFactory);
		rt.setKeySerializer(new StringRedisSerializer());
		rt.setValueSerializer(new JdkSerializationRedisSerializer());
		return rt;
	}
	
	/**   
	 * @Title: getJedisConnectionFactory   
	 * @Description: TODO  
	 * @param poolConfig
	 * @return JedisConnectionFactory
	 */
	@Bean(name="jedisConnectionFactory")
	public JedisConnectionFactory getJedisConnectionFactory(JedisPoolConfig poolConfig){
		log.info("redis connection factory begain......");
		JedisConnectionFactory jcf = new JedisConnectionFactory();
		jcf.setPoolConfig(poolConfig);
		String host = null;
		String port = null;
		try {
			host = env.getProperty("spring.redis.host");
			if(StringUtils.isEmpty(host)){
				CloudException.throwCloudException("Redis主机名为空！");
			}
		} catch (Exception e) {
			if(e instanceof CloudException){
				throw e;
			}
			CloudException.throwCloudException("Redis主机名读取异常！",e);
		}
		
		
		try {
			port = env.getProperty("spring.redis.port");
			if(StringUtils.isEmpty(port)){
				CloudException.throwCloudException("Redis端口号为空！");
			}
		} catch (Exception e) {
			if(e instanceof CloudException){
				throw e;
			}
			CloudException.throwCloudException("Redis端口号读取异常！",e);
		}
		log.info("*********  redis host is :"+host);
		log.info("*********  redis port is :"+port);
		jcf.setHostName(host);
		jcf.setPort(Integer.valueOf(port));
		return jcf;
	}
}