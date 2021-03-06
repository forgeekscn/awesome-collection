package cn.forgeeks.awesome.redis.common;

/**
 * Redis confiuration.
 */
//@Configuration
//@Slf4j
public class RedisConfig {

//    @Value("${redis.hostName}")
//    private String hostName;
//
//    @Value("${redis.port}")
//    private Integer port;
//
//    @Value("${redis.password}")
//    private String password;
//
//    @Value("${redis.timeout}")
//    private int timeout;
//
//    @Value("${redis.maxIdle}")
//    private Integer maxIdle;
//
//    @Value("${redis.maxTotal}")
//    private Integer maxTotal;
//
//    @Value("${redis.maxWaitMillis}")
//    private Integer maxWaitMillis;
//
//    @Value("${redis.minEvictableIdleTimeMillis}")
//    private Integer minEvictableIdleTimeMillis;
//
//    @Value("${redis.numTestsPerEvictionRun}")
//    private Integer numTestsPerEvictionRun;
//
//    @Value("${redis.timeBetweenEvictionRunsMillis}")
//    private long timeBetweenEvictionRunsMillis;
//
//    @Value("${redis.testOnBorrow}")
//    private boolean testOnBorrow;
//
//    @Value("${redis.testWhileIdle}")
//    private boolean testWhileIdle;
////
////    @Value("${spring.common.cluster.nodes}")
////    private String clusterNodes;
////
////    @Value("${spring.common.cluster.max-redirects}")
////    private Integer mmaxRedirectsac;
//
//    /**
//     * JedisPoolConfig 连接池
//     * @return
//     */
//    @Bean
//    public JedisPoolConfig jedisPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxTotal(maxTotal);
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
//        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
//        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
//        return jedisPoolConfig;
//    }
//
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
//        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
//        JedisConnectionFactory.setPoolConfig(jedisPoolConfig);
//        JedisConnectionFactory.setHostName(hostName);
//        JedisConnectionFactory.setPort(port);
//        JedisConnectionFactory.setPassword(password);
//        JedisConnectionFactory.setTimeout(timeout);
//        log.info("redis缓存配置中");
//        return JedisConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> functionDomainRedisTemplate(RedisConnectionFactory
//                                                                         jedisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        initDomainRedisTemplate(redisTemplate, jedisConnectionFactory);
//        log.info("redis缓存配置中");
//        return redisTemplate;
//    }
//
//    /**
//     * 设置数据存入 common 的序列化方式,并开启事务
//     */
//    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setEnableTransactionSupport(true);
//        redisTemplate.setConnectionFactory(factory);
//        log.info("redis缓存配置中");
//    }
//
//    @Bean(value = "cn.forgeeks.awesome.redis.common.RedisUtil" )
//    public RedisUtil redisUtil(RedisTemplate<String, Object> functionDomainRedisTemplate) {
//        RedisUtil redisUtil = new RedisUtil();
//        redisUtil.setRedisTemplate(functionDomainRedisTemplate);
//        log.info("###################   redis缓存配置完成   #######################");
//        return redisUtil;
//    }
}