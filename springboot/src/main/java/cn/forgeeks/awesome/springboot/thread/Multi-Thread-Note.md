
## 关注点
 
- 什么是Java内存模型？
    - 内存模型描述了线程之间如何通过内存进行交互,包括三个区域,heap堆,stack栈,method方法区
    - 对象实例放在heap,局部变量基本数据类型对象引用放在stack,类信息静态变量常量放在method
    - 内存模型有三个重要关键字valitile,sycronized,final ,valitile有两种内存语义:可见性和有序性
    - 编译器优化过程可能会打乱指令原本顺序,用valitile修饰的变量操作会拒绝指令重排序
    - 另外用valitile修饰的变量会刷到主存,每个线程的本地内存会在访问该变量时先去主存拉取数据,这样能保证该变量对所有线程都具有一致性

- 什么是CAS？
    - 也就是compare and swap 顾名思义,先比较实际取到的值是否和预期的相等,是就赋值否则失败
    - 他是乐观锁,优点是所有的读改写操作都是原子操作,由汇编指令lock实现,适合冲突少的场景
    - 缺点是如果值多次改变后与原来值一样,compare时候会认定他没有变,从而执行覆盖操作,这样会带来并发问题,思路是用版本号
    - 另外还有cas自旋开销大,在锁竞争激烈情况下会带来严重cpu消耗
    - 最后是cas只能保证一个共享变量的原子操作

- 什么是Executors框架？
    - 管理线程的框架,比thread高效方便安全
    - 重要的接口有ThreadPoolExecutor可用来自定义线城池,关键参数如下
      + 最大并发数
      + 线程总数
      + 超时时间
      + 工作队列

- 什么是阻塞队列？如何使用阻塞队列来实现生产者-消费者模型？
    - 达到最大并发会进入等待队列
    - 使用ArrayBlockingQueue实现生产者add,消费者take

- 什么是同步容器和并发容器的实现？
    - 同步容器：Stack,Vector,HashTable
    - 异步容器：java.util.concurrent里面有ConcurrentHashMap:使用分段锁, 
               CopyOnWriteArrayList：写时复制容器切换引用,不影响并发读,不会出现读写不一致 

- 什么是多线程的上下文切换？
    - cpu分配时间片给线程,通过不断切换来维持,期间会记录尚未完成线程任务的各种状态以便下一个时间片接着执行，简单总结下原因
        + 线程竞争资源
        + cpu切换
        + io阻塞
    - 上下文切换影响多线程效率,可以通过以下方式避免
        + 无锁并发：用hash路由来分而治之，减少资源竞争
        + cas算法：用处理器LOCK指令来维持原子操作和并发安全，避免加锁，减少资源竞争
        + 避免使用多线程

- ThreadLocal的设计理念与作用？
    - 多线程各取所用互不干扰
    - 项目中用ThreadLocal<ConcurrentHashMap>来保存多用户会话信息

- synchronized和ReentrantLock的区别？
    - synchronized：jvm层面锁,可以锁住代码块和方法,jvm编译会自动加上monitorEnter和monitorExit,持有锁+1释放锁-1
    - ReentrantLock: api层面的锁，功能更多，需要手动lock和unlock,还要配合try/finnaly使用,可以配置以下:
        + tryLock避免死锁 
        + ReentrantReadWriteLock读写锁避免阻塞并发读
        + ReentrantLock获取是否成功获取锁
        
- concurrentHashMap 原理 ？
    - 1.7版本的还使用的分段锁,底层是segment+hashEntity 具体是数组+链表/红黑树
    - 1.8版本使用syncronize锁和cas算法实现同步，底层也是数组+链表/红黑树，get不加锁，set只有在hash冲突才会用锁否则会用cas算法无锁更新

- ReentrantReadWriteLock读写锁的使用？
    - 加了读锁可以再加写锁， 加了写锁不可以再加读锁，这是为了保证写独占读并发

- CyclicBarrier和CountDownLatch的用法及区别？
    - CountDownLatch: 倒计数器 等指定数目线程到达 只用一次
    - CyclicBarrier : 栏栅 等指定数目线程到达 可多次使用
    - Semaphore：信号量 用在资源竞争的场景

- 高并发、任务执行时间短的业务怎样使用线程池？并发不高、任务执行时间长的业务怎样使用线程池？并发高、业务执行时间长的业务怎样使用线程池？
    - 高并发、任务执行时间短：线程数设置为cpu核数+1，减少上下文切换
    - 并发不高、任务执行时间长：
        + io密集型任务：不让cpu闲着，增加线程数
        + 计算密集型任务：线程数设置为cpu核数+1，考虑增加机器性能
    - 并发高、业务执行时间长：考虑使用缓存和中间件
    
- 锁的等级：方法锁、对象锁、类锁?
    - 方法锁：静态方法上加syncronize 或者 代码块sychronized(Object.class){ } 
    - 类锁：非静态方法加syncronized 或者 代码块sychronized(this / Object ){ } 

- 如何保证多线程下 i++ 结果正确？
    - 自增方法或者代码块加sycronized
    - AutomicInteger

- 一个线程如果出现了运行时异常会怎么样?
    - 释放所持有的锁
    
- 如何在两个线程之间共享数据?
    - 定义volitale的局部变量，自增方法加锁

- 生产者消费者模型的作用是什么?
    - 管理可用资源，缓冲高并发的消费请求

- 怎么唤醒一个阻塞的线程?
    - notify
    
- Java中用到的线程调度算法是什么
    - 不知道

- 单例模式的线程安全性?
    - 非线程安全,加volatile
    
- 线程类的构造方法、静态块是被哪个线程调用的?
    - 主线程

- 同步方法和同步块，哪个是更好的选择?
    - 同步

- 如何检测死锁？怎么预防死锁？
    - 老子不知道


## 参考

- 五月的仓颉：https://www.cnblogs.com/xrq730/p/5060921.html
- 对象锁和类锁：https://blog.csdn.net/u013142781/article/details/51697672