package com.pt;

import org.springframework.beans.factory.FactoryBean;

public class ObjectFactoryBean implements FactoryBean<ObjectFactory> {

	@Override
	public ObjectFactory getObject() throws Exception {
		System.out.println("getObject()");
		return new ObjectFactory();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
