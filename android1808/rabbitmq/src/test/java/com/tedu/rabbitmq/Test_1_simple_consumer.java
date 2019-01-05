package com.tedu.rabbitmq;

import java.util.HashMap;

import org.junit.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

//消息消费者(消息接受者):从队列取消息,处理消息
public class Test_1_simple_consumer {

	@Test
	public void consumer() throws Exception{
		//1.创建连接
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("192.168.80.136");
		factory.setPort(5672);
		factory.setUsername("jtadmin");
		factory.setPassword("jtadmin");
		factory.setVirtualHost("/jt");
		Connection connection = factory.newConnection();
		//2.得到通道channel
		Channel channel = connection.createChannel();
		
		//申明队列
		String queue="orderQueue1";
		boolean durable=true;
		boolean exclusive=false;
		boolean autoDelete=false;
		HashMap<String, Object> arguments=null;
		//如果队列存在,不创建队列
		//如果先启消费者,提供者没有创建队列,消费者自动创建队列
		channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
		
		//3.创建consumer
		//消费者consumer是通过channel连上服务器的
		QueueingConsumer consumer=new QueueingConsumer(channel);
		//4.通过channel把consumer和队列连接起来
		String queueName="orderQueue1";
		//自动确认:消费者收到消息后,自动发给服务器发个消息,告诉服务器,我收到了,服务器就删除消息
		//false:手动确认
		boolean autoAck=false;
		channel.basicConsume(queueName, autoAck, consumer);
		//5.遍历consumer,consumer相当于JDBC中的结果集
		while(true){
			//Delivery是个实体类,包含消息和消息id
			Delivery delivery = consumer.nextDelivery();
			//取消息
			byte[] body = delivery.getBody();
			System.out.println("消费者1取到的 内容"+new String(body));
			
			//添加发送确认信息代码
			try {
				long deliveryTag=delivery.getEnvelope().getDeliveryTag();
				System.out.println("deliveryTag="+deliveryTag);
				channel.basicAck(deliveryTag, true);
				System.out.println("1发送确认消息");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
