package com.jt.manage.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.jt.manage.pojo.User;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Transaction;


public class TestRedis {

	/**
	 * 1.连接Redis IP:端口
	 */
	@Test
	public void testString(){
		Jedis jedis=new Jedis("192.168.80.134",6379);
		jedis.set("1808", "端口附近大家覅恩恩,及的分解!");
		System.out.println("输出:"+jedis.get("1808"));
		
		jedis.expire("1808", 10);
		//设定数据同时设定超时时间
		jedis.setex("abc",20 , "123");
		
	}
	@Test
	public void testHash(){
		User user = new User();
		user.setId(1565);
		user.setName("端口附近");
		user.setAge(25);
		user.setSex("女");
		Jedis jedis = new Jedis("192.168.80.134",6379);
		jedis.hset("user1", "id", user.getId()+"");
		jedis.hset("user1", "name", user.getName()+"");
		jedis.hset("user1", "age", user.getAge()+"");
		Map<String, String> map = jedis.hgetAll("user1");
		System.out.println(map);
	}
	@Test
	public void tesrList(){
		Jedis jedis = new Jedis("192.168.80.134",6379);
		jedis.lpush("list", "1","2","3","4");
		//当做队列使用
		System.out.println(jedis.rpop("list"));
		
	}
	//测试redis中的事务
	@Test
	public void testTx(){
		Jedis jedis = new Jedis("192.168.80.134",6379);
		//开启事务
		Transaction transaction = jedis.multi();
		
		//数据操作
		transaction.set("1808", "tomcat大真分数的");
		//transaction.exec();
		transaction.discard();
		System.out.println(jedis.get("1808"));
		
	}
	@Test
	public void testShard(){
		//定义多个redis
		List<JedisShardInfo> shards=new ArrayList<>();
		shards.add(new JedisShardInfo("192.168.80.134",6379));
		shards.add(new JedisShardInfo("192.168.80.134",6380));
		shards.add(new JedisShardInfo("192.168.80.134",6381));
		ShardedJedis shardedJedis = new ShardedJedis(shards);
		shardedJedis.set("shards", "redis分片技术");
		System.out.println(shardedJedis.get("shards"));
		shardedJedis.close();
	}
	@Test
	public void testShardPool(){
		//定义连接池
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(1000);//最大连接数量
		poolConfig.setMaxIdle(50);//最大的空闲数量
		poolConfig.setMinIdle(10);//最小的空闲连接数量
		
		//定义多个redis
		List<JedisShardInfo> shards=new ArrayList<>();
		shards.add(new JedisShardInfo("192.168.80.134",6379));
		shards.add(new JedisShardInfo("192.168.80.134",6380));
		shards.add(new JedisShardInfo("192.168.80.134",6381));
		ShardedJedisPool pool = new ShardedJedisPool(poolConfig,shards);
		ShardedJedis shardedJedis = pool.getResource();
		shardedJedis.set("shards", "redis分片技术");
		System.out.println(shardedJedis.get("shards"));
		pool.returnResource(shardedJedis);
	}
	
	//实现哨兵的测试
	@Test
	public void testSentinel(){
		//1.定义池
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(1000);
		
		//将redis哨兵的节点写入集合
		Set<String> sentinels=new HashSet<>();
		sentinels.add("192.168.80.134:26379");
		sentinels.add("192.168.80.134:26380");
		sentinels.add("192.168.80.134:26381");
		
		JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels);
		
		Jedis jedis = pool.getResource();
		jedis.set("1808", "1808dksfhi");
		System.out.println(jedis.get("1808"));
		pool.returnResource(jedis);
	}
	@Test
	public void testCluster(){
		
		Set<HostAndPort> nodes=new HashSet<>();
		nodes.add(new HostAndPort("192.168.80.134", 7000));
		nodes.add(new HostAndPort("192.168.80.134", 7001));
		nodes.add(new HostAndPort("192.168.80.134", 7002));
		nodes.add(new HostAndPort("192.168.80.134", 7003));
		nodes.add(new HostAndPort("192.168.80.134", 7004));
		nodes.add(new HostAndPort("192.168.80.134", 7005));
		nodes.add(new HostAndPort("192.168.80.134", 7006));
		nodes.add(new HostAndPort("192.168.80.134", 7007));
		nodes.add(new HostAndPort("192.168.80.134", 7008));
		JedisCluster cluster = new JedisCluster(nodes);
		cluster.set("1808","几时放假");
		System.out.println(cluster.get("1808"));
	}
}
