package cn.tedu.flux;

import java.util.UUID;

import org.junit.Test;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;
import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;

public class FluxTopology {
	@Test
	public void print() throws InterruptedException{
		//1.配置，zk集群
		BrokerHosts hosts = new ZkHosts(
				"hadoop01:2181,hadoop02:2181,hadoop03:2181");
		
		//第一个参数：配置kafka所在zk集群，通过zk让storm和kafka联系起来;
		//第二个参数：topic名称
		//第三个参数：kafka保存zk中，树型结构，根 /flux
		//第四个参数：唯一代表，uuid产生一个唯一值
		SpoutConfig sc = new SpoutConfig(hosts,"flux","/flux",UUID.randomUUID().toString());
		sc.scheme = new SchemeAsMultiScheme(new StringScheme());
		
		//1.创建KafkaSpout对象，把传入的string封装成一个tuple，传入bolt
		KafkaSpout spout = new KafkaSpout(sc);

		//2.自定义Bolt，Bolt中用户可以自由修改数据（清洗）
//		ClearBolt clearBolt = new ClearBolt();
		PrintBolt printBolt = new PrintBolt();
				
		//3.绑定关系，spout和bolt关系，最简单就一层关系		
		TopologyBuilder builder =  new TopologyBuilder();
		//程序的入口，调用流程
		builder.setSpout("Flux_Spout", spout);
		//调用bolt也配置好
//		builder.setBolt("Clear_Bolt", clearBolt)
//			.shuffleGrouping("Flux_Spout");	//流程的关系绑定
		builder.setBolt("Print_Bolt", printBolt)
			.shuffleGrouping("Flux_Spout");	//流程的关系绑定
		
		//顺序结构：Flux_Spout > Clear_Bolt > Print_Bolt
		
		//4.执行，两种方式（本地测试，提交storm服务器）
		StormTopology topology = builder.createTopology();
				
		//5.提交测试
		LocalCluster cluster = new LocalCluster();
		Config config = new Config();	//定义好的默认配置
		
		//提交到本地测试
		cluster.submitTopology("Flux_Spout", config, topology);

		//有时启动非常快，有时很慢25s，才可以使用
		System.out.println("Start Topology...");
		
		
		//上面进程一直存在，如果闲置一段时间没有就关闭，可以设置下面的语句
		Thread.sleep(60*1000*1000);		//闲置100秒就关闭	
		cluster.killTopology("");
		cluster.shutdown();
		
	}
	
	
}
