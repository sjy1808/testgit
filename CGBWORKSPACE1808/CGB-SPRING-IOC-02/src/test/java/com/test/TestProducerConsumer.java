package com.test;

import org.junit.Test;

import com.beans.Consumer;
import com.beans.Container;
import com.beans.Producer;

public class TestProducerConsumer extends TestBase{

	@Test
	public void testProducerConsumer(){
		//1.获取生产者对象
		Producer producer = ctx.getBean("producer",Producer.class);
		//2.通过生产者向容器中放数据
		producer.add("dfsf");
		producer.add("123");
		producer.add("fgrg");
		//3.获取消费者对象
		Consumer consumer = ctx.getBean("consumer", Consumer.class);
		//4.通过消费者从容器取数据,然后输出
		Object a=consumer.get();
		Object b=consumer.get();
		System.out.println(a);
		System.out.println(b);
		
		
	}
}
