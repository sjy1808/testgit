package com.tedu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListenerDemo2 {
	public static void main(String[] args) {
		//1.创建一个窗口(对象)
		JFrame frame = new JFrame();
		//2.设置窗口的大小和位置
		frame.setSize(250,200);
		frame.setLocationRelativeTo(null);//窗口居中
		
		//4.创建一个按钮,并将按钮添加到窗口中
		JButton btn = new JButton("别点我~!");
		frame.add(btn);
		//5.创建一个监听器
		ActionListener listener = new MyActionListener();
		
		//6.将监听器注册到按钮
		btn.addActionListener(listener);
		/*
		 * 将监听器注册到按钮上之后,监听器将会一直监听着按钮的状态变化,当按钮
		 * 被点击之后,就会立即通知监听器,监听器就会调用方法来处理"按钮被点击"
		 * 事件
		 * 事件源:按钮
		 * 事件:按钮被点击
		 * 监听器:listener
		 */
		//3.设置窗口为显示状态
		frame.setVisible(true);
	}
}
class MyActionListener implements ActionListener{
	//在监听器触发时执行
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Hello...");
		
	}
	
}
