package com.jt.common.factory;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterFactory implements FactoryBean<JedisCluster> {

	private Resource propertySource;
	private GenericObjectPoolConfig poolConfig;
	private String redisNodePrefix;
	
	public Resource getPropertySource() {
		return propertySource;
	}
	public void setPropertySource(Resource propertySource) {
		this.propertySource = propertySource;
	}
	public GenericObjectPoolConfig getPoolConfig() {
		return poolConfig;
	}
	public void setPoolConfig(GenericObjectPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}
	public String getRedisNodePrefix() {
		return redisNodePrefix;
	}
	public void setRedisNodePrefix(String redisNodePrefix) {
		this.redisNodePrefix = redisNodePrefix;
	}
	@Override
	public JedisCluster getObject() throws Exception {
		Set<HostAndPort> nodes=getNodes();
		JedisCluster jedisCluster=new JedisCluster(nodes,poolConfig);
		return jedisCluster;
	}
	//定义如何从source源中获取需要的set集合
	public Set<HostAndPort> getNodes() {
		Set<HostAndPort> sets=new HashSet<HostAndPort>();
		try {
			//加载配置文件
			Properties properties = new Properties();
			properties.load(propertySource.getInputStream());//加载资源文件
			
			//循环遍历key的值
			for(Object key:properties.keySet()){
				String propertyKey=(String) key;
				if(!propertyKey.startsWith(redisNodePrefix)){
					continue;
				}
				String value = properties.getProperty(propertyKey);
				String[] args = value.split(":");
				//为hostAndPort进行赋值操作
				HostAndPort hostAndPort = new HostAndPort(args[0], Integer.parseInt(args[1]));
				sets.add(hostAndPort);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sets;
	}

	@Override
	public Class<?> getObjectType() {
		return JedisCluster.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
