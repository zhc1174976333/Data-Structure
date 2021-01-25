package com.zhc.test.haicheng.list;

/**
 * vector  线程安全
 *     扩容因子：2倍
 *     复合操作需要程序自己控制线程安全
 */

/**
 * ArrayList  查找快   线程不安全
 * 数组：下标查询   连续内存，存储相同类型的元素   每一个元素占用的内存空间是相同的
 *
 *
 * LinkedList  插入快
 *
 *
 *
 *
 * 序列化，反序列化   作用：转化为二进制对象，进行存盘，并可进行网络传输
 *
 */

/**
 * 深拷贝
 * 浅拷贝    基本类型是独立的，不会受到clone干扰，   引用类型是不独立的
 *
 * 拷贝的都是栈中的内容
 *
 * 基本类型存在栈中
 * 引用类型在栈中存放的是地址，对应堆中的实际值
 *
 * String值 final修饰，存放在堆中的常量池
 * String的拷贝，是在常量池中重新生成一个常量，将拷贝的String指向新的常量
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 时间复杂度
 *     参数与函数执行次数的关系
 *
 *     线性相关   O(n)
 *     常量级   O(1)      a(int i) { sout{i}}
 *     指数相关   O(n^2)
 *     对数相关     二分查找   logN
 *     线性对数相关    nlogN
 *
 */

public class arrayListTest {

    /**
     * ArrayList
     *
     * 默认容量 10
     *
     * 添加元素：   判断容量，当元素length > 容量大小，触发扩容（1.5倍），当元素length > 1.5倍的容量大小，则再判断是否超过（int最大长度 - 8），8位数组本身维护占用的长度，超过则取最大的极值，
     *                 确定容量后，进行数组拷贝，将老的数组的元素拷贝到新的数组中（相比较LinkedList插入慢，就是因为拷贝）
     *                 默认尾部添加元素
     *
     *                 初始化指定容量，可以减少扩容次数（这样可能不会比LinkedList插入慢）（LinkedList会创建节点）
     *
     * 指定下标添加元素 O(n)：  将指定的下标之后的元素，依次向后以为拷贝（相当于后移一位），最后将要添加到指定下标的元素copy到该处
     *
     *
     * 删除元素：
     *
     *
     * transient  表示不参与序列化（ArrayList中会存在元素为null）   jdk本身的序列化
     *
     * Arrays.asList()
     *
     */

    public static void main(String[] args) {
//        testArraysAsList();

        testUnmodifiableList();
    }

    // Arrays.asList 一个注意点
    public static void testArraysAsList() {
        long[] arr = new long[]{1l,2l,3l,4l};

        Long[] arrays = new Long[]{1l,2l,3l,4l};

        /**
         * Arrays.asList会对基本类型的数组进行new一个新的数组，将原基本类型的数组放进新的数组当做参数
         * 原因就是基本类型不支持泛型化
         * 基本类型的数组，最后会成为一个对象，包装成一个二维数组
         */
        List arrList = Arrays.asList(arr); // 基本类型不支持泛型化，数组不支持向下转型（基本类型与封装类型不能自动拆装箱）
        List arraysList = Arrays.asList(arrays);

        System.out.println(arrList.size());  // 1
        System.out.println(arraysList.size()); // 4
    }


    // 不可变集合
    public static void testUnmodifiableList () {
        List list = new ArrayList(Arrays.asList(1,2,3,4,5,6,7));

        List modifiableList = Collections.unmodifiableList(list);

        /**
         * 当原list发生变化，不可变集合会受原list变化影响
         *
         * unmodifiableList 没有add等一系列方法
         */
//        modifiableList.add(2); // Exception

        list.set(1,0); // 修改原list，unmodifiableList也会跟着变化

        System.out.println(modifiableList.get(1));
    }

}
