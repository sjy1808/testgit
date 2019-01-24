package cn.tedu.flux;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class ClearBolt extends BaseRichBolt{
	//声明输出的集合结构
		private OutputCollector collector;

		@Override
		public void execute(Tuple tuple) {
			//获取到一行数据
			String line = tuple.getStringByField("str");	//约定
			
			//http://localhost/b.jsp|b.jsp|页面B|UTF-8|1024x768|24-bit|zh-cn|0|1||0.38558604697617627|http://localhost/a.jsp|Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3343.4 Safari/537.36|95686657276343000667|6451334604_2_1520237901534|0:0:0:0:0:0:0:1
			
			//按竖杠进行拆串
			String[] values = line.split("\\|");
			
			String url = values[0];
			String urlname = values[1];
			String uvid = values[13];
			
			//6451334604_2_1520237901534
			String[] a = values[14].split("_");
			String ssid = a[0];
			String sscount = a[1];
			String sstime = a[2];
			String cip = values[15];
			
			//将数据写入到下一个Tuple结构中？list(k="url",v=url)
			//分成两步：1.形成数据集合Values集合，2.对应这个集合的结构配合名称集合
			collector.emit(new Values(url,urlname,uvid,ssid,sscount,sstime,cip));
			
		}

		@Override //内部传递数据，通过一个输出的集合对象
		public void prepare(Map map, TopologyContext context, OutputCollector opc) {
			collector = opc;
		}

		@Override //重新定义属性名称
		public void declareOutputFields(OutputFieldsDeclarer declarer) {
			//重新定义属性集合，这个集合的每个名称要和上面的值集合一一对应
			declarer.declare(new Fields("url","urlname","uvid","ssid","sscount","sstime","cip"));
			
		}
}
