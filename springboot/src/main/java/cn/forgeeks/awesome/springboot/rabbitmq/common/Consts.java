package cn.forgeeks.awesome.springboot.rabbitmq.common;

/**
 * Consts args config.
 */
public class Consts {
    // 主题
    public static final String EXCHANGE_MYTH_TOPIC = "EXCHANGE.MYTH.TOPIC";

    // 日志队列
    public static final String QUEUE_MYTH_LOG_INFO ="QUEUE.MYTH.LOG.INFO" ;
    public static final String QUEUE_MYTH_LOG_ERROR ="QUEUE.MYTH.LOG.ERROR" ;
    public static final String QUEUE_MYTH_LOG_ALL ="QUEUE.MYTH.LOG.ALL" ;
    // 邮件队列
    public static final String QUEUE_MYTH_MAIL_ALL ="QUEUE.MYTH.MAIL.ALL" ;
    // 订单秒杀队列
    public static final String QUEUE_MYTH_ORDER_ALL = "QUEUE.MYTH.ORDER.ALL";

    // 路由
    public static final String ROUTING_MYTH_LOG_INFO = "ROUTING.MYTH.LOG.INFO";
    public static final String ROUTING_MYTH_LOG_WARN = "ROUTING.MYTH.LOG.WARN";
    public static final String ROUTING_MYTH_LOG_ERROR = "ROUTING.MYTH.LOG.ERROR";
    public static final String ROUTING_MYTH_LOG_SIMPLE_DIRECT ="ROUTING.MYTH.LOG.SIMPLE.DIRECT" ;
    // 邮件路由
    public static final String ROUTING_WITH_REGULER_MODULE_ALL_MYTH_MAIL= "QUEUE.MYTH.MAIL.#";
    // All modules and all types of log.
    public static final String ROUTING_WITH_REGULER_MODULE_ALL_MYTH_LOG_ALL = "QUEUE.MYTH.LOG.#";
    // ALL modules and error log.
    public static final String ROUTING_WITH_REGULER_MODULE_ALL_MYTH_LOG_ERROR = "QUEUE.MYTH.LOG.ERROR";
    public static final String ROUTING_WITH_REGULER_MODULE_ALL_MYTH_LOG_INFO= "QUEUE.MYTH.LOG.INFO";
    public static final String ROUTING_WITH_REGULER_MODULE_ALL_MYTH_ORDER_ALL= "QUEUE.MYTH.ORDER.#";

    // Job works take time.
    public static final long TIME_OF_WORKJOB = 5000;
}
