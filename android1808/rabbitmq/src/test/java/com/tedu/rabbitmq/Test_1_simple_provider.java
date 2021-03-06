package com.tedu.rabbitmq;

import java.util.HashMap;

import org.junit.Test;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Test_1_simple_provider {

	//向消息队列写信息
	@Test
	public void provider() throws Exception{
		//1.连接服务器,建立连接
		ConnectionFactory factory=new ConnectionFactory();
		//1.1指定服务器IP
		factory.setHost("192.168.80.136");
		//1.2设置端口号
		//rabbitmq有两个端口号,访问15672服务器返回是后台管理网页
		//访问5672可以发送消息,收消息
		factory.setPort(5672);
		//1.3设置用户名,密码
		factory.setUsername("jtadmin");
		factory.setPassword("jtadmin");
		//1.4设置虚拟机
		factory.setVirtualHost("/jt");
		Connection connection = factory.newConnection();
		//2.得到channel
		Channel channel = connection.createChannel();
		//3.创建队列
		String queueName="orderQueue1";
		//队列不保存到硬盘上
		boolean durable=true;
		//false 别的程序能访问这个队列,true别的程序不能访问这个队列,相当于java中的public
		boolean exclusive=false;
		//队列用完了,不会自动删除
		HashMap<String, Object> arguments=null;
		boolean autoDelete=false;
		channel.queueDeclare(queueName, durable, exclusive, autoDelete, arguments);
		//4.发消息
		//值是空串,使用的是default exchange
		String exchange="";
		//routing路由,指定发到orderQueue1队列
		String routingKey=queueName;
		//设置参数
		//BasicProperties props=null;
		//实现消息的持久化,保存到硬盘上
		//Builder是BasicProperties的内部类
		BasicProperties.Builder builder=new Builder();
		//把消息保存到硬盘上
		builder.deliveryMode(2);
		BasicProperties props=builder.build();
		//发送参数信息
		byte[] body="msg2".getBytes();
		channel.basicPublish(exchange, routingKey, props, body);
		//5.关闭channel,connection
		channel.close();
		connection.close();
		//不关闭连接
//		System.out.println("发送数据成功");
//		while(true){
//			
//		}
	}
}
