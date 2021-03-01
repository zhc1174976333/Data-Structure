package com.zhc.test.haicheng.redis;

public class RedisTest {

    /**
     * 数据类型：String   ------
     *         hash     适用对象缓存，
     *                 优点：
     *                  同类数据归类整合存储，方便数据管理
     *                  相比string操作消耗内存与cpu更小
     *                  相比string储存更节省空间
     *                缺点：
     *                  过期功能不能使用在field上，只能用在key上
     *                  Redis集群架构下不适合大规模使用
     *
     *          list   常用数据结构： 栈（先进后出FILO）
     *                             队列
     *                             阻塞队列
     *
     *          set
     *
     *          zset
     */

    /**
     * redis 执行命令是单线程的
     *       持久化、异步删除、集群数据同步等由额外的线程执行
     *
     * 数据都在内存中
     *
     * I/O多路复用
     *        客户端指令分发，放在队列中（I/O多路复用程序）---> 文件时间分派器 ---> 事件处理器
     */
}
