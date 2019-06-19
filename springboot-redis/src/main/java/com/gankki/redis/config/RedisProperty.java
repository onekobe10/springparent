package com.gankki.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Jedis pool配置类
 *
 * @author dell xps15
 *
 */
@Data
@ConfigurationProperties(prefix = "spring.redis.jedis")
public class RedisProperty {

    private String host = "localhost";

    private int port = 6379;

    private String password;

    private int timeout;

    private boolean ssl;

    private int database;

    private Pool pool;

    private Cluster cluster;



    /**
     * Pool properties.
     */
    @Data
    public static class Pool {

        /**
         * Max number of "idle" connections in the pool. Use a negative value to
         * indicate an unlimited number of idle connections.
         */
        private int maxIdle = 8;

        /**
         * Target for the minimum number of idle connections to maintain in the pool.
         * This setting only has an effect if it is positive.
         */
        private int minIdle = 0;

        /**
         * Max number of connections that can be allocated by the pool at a given time.
         * Use a negative value for no limit.
         */
        private int maxActive = 8;

        /**
         * Maximum amount of time (in milliseconds) a connection allocation should block
         * before throwing an exception when the pool is exhausted. Use a negative value
         * to block indefinitely.
         */
        private int maxWait = -1;


    }

    /**
     * Cluster properties.
     */
    @Data
    public static class Cluster {

        /**
         * Comma-separated list of "host:port" pairs to bootstrap from. This represents
         * an "initial" list of cluster nodes and is required to have at least one
         * entry.
         */
        private List<String> nodes;

        /**
         * Maximum number of redirects to follow when executing commands across the
         * cluster.
         */
        private Integer maxRedirects;



    }

}
