package com.gankki.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;

/**
 * 
 * @Description:redis 配置类 
 * @author: xyz
 * @date:   2019年4月13日 下午4:25:08   
 *
 */
@Configuration
@EnableConfigurationProperties(RedisProperty.class)
public class RedisAutoConfiguration {


    @Bean
    @ConfigurationProperties(prefix = "spring.redis.jedis.pool")
    public JedisPoolConfig getJedisPoolConfig(){

        return new JedisPoolConfig();
    }
    @Bean
    public JedisPool getJedisPool(RedisProperty redisProperty) {
        JedisPool jedisPool = new JedisPool(getJedisPoolConfig(), redisProperty.getHost(), redisProperty.getPort(),
                redisProperty.getTimeout(), redisProperty.getPassword(), redisProperty.getDatabase());

        return jedisPool;
    }

    /**
     * redis 集群配置
     * @Bean
     * @return
     */
    public JedisCluster getJedisCluster(RedisProperty redisProperty) {

        List<String> nodesList = redisProperty.getCluster().getNodes();
        HashSet<HostAndPort> nodesSet = new HashSet<HostAndPort>();
        if (nodesList != null && nodesList.size() > 0) {
            for (String node : nodesList) {
                if (node != null) {
                    String[] hostAndPort = node.split(":");
                    HostAndPort hostAndPort2 = new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1]));
                    nodesSet.add(hostAndPort2);
                }
            }
        }

        return new JedisCluster(nodesSet);
    }



}
