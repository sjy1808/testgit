package cn.tedu;

import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Override
	public void hello() {
		System.out.println("hello Service!!");
	}

}