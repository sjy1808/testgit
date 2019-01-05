package com.tedu.rabbitmq;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Test_3_publish_provider {

	// 向消息队列写消息
	@Test
	public void provider() throws Exception {
		// 1,连接服务器
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.80.136");
		// 浏览器访问rabbitmq后台管理用的是15672
		// 发消息用的的5672
		// 一个服务器可以有多个端口号，访问15672,服务器返回的是网页
		// 访问5672,可以发消息，也可以取消息
		factory.setPort(5672);
		factory.setUsername("jtadmin");
		factory.setPassword("jtadmin");
		factory.setVirtualHost("/jt");
		// 2,得到channel
		// com.rabbitmq.client.connection
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// 定义交换机
		String exchangeName = "E1";
		// fanout 订阅模式
		// direct 路由模式
		// topic 主题模式
		channel.exchangeDeclare(exchangeName, "fanout");
		// channel.queueDeclare("order", true, false,false, null);
		// 4,写消息
		boolean isRunning = true;

		String msg = "msg 01";
		String routingKey = "";
		BasicProperties properties = null;
		channel.basicPublish(exchangeName, routingKey, properties, msg.getBytes());

		// 5,关闭连接
		channel.close();
		connection.close();
		// System.out.println("发送了" + msg);
	}

}
