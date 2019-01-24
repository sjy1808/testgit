package cn.tedu.flux;

import java.util.Iterator;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class PrintBolt extends BaseRichBolt {

		public void execute(Tuple tuple) {

			Fields fields = tuple.getFields();
			Iterator<String> iter = fields.iterator();
			while(iter.hasNext()){
				String key = iter.next();
				String val = tuple.getStringByField(key);
				System.out.println("key:"+key+" val:"+val);
			}
		}

		@Override
		public void prepare(Map arg0, TopologyContext arg1, OutputCollector arg2) {

		}

		@Override
		public void declareOutputFields(OutputFieldsDeclarer declarer) {

		}


}
