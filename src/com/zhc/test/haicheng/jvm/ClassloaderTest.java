package com.zhc.test.haicheng.jvm;

public class ClassloaderTest {

    /**
     * 类加载器
     *
     *    引导类加载器      BootstrapClassLoader  加载的是jre下的lib中的核心包   c++实现    核心类库都不允许外部加载器加载
     *    扩展类加载器      ExtClassLoader        加载的是jre下的lib中的ext下的包   Java实现
     *    应用程序类加载器  AppClassLoader         加载的是应用类（我们写的大多数代码）
     *
     *
     *
     *  双亲委派
     *     加载一个类，先去应用程序类加载器loadClass
     *
     *
     *     a class --->  AppClassLoader 加载过 --> return class
     *                                  未加载过 --> ExtClassLoader 加载过 --> return class
     *                                                             未加载过 --> BootstrapClassLoader 加载过  --> return class
     *                                                                                              未加载过 --> 一系列的校验（是否该类加载器可以加载）
     *                                                                                                                  |
     *                                                                                                                  |
     *                                                                       BootstrapClassLoader加载类  <--  可以加载  <--
     *                                                                       ExtClassLoader是否可以加载  <-- 不可以加载  <--
     *                                                     ExtClassLoader加载类  <--  可以加载  <--
     *                                                  AppClassLoader是否可以加载  <--不可以加载<--
     *                                    AppClassLoader加载类<--可以加载<--
     *                               ClassNotFoundException<--不可以加载<--
     *
     *
     *
     *
     *  为什么设计双亲委派机制
     *      1、沙箱安全机制，防止核心API库被随意篡改
     *      2、避免类的重复加载，当父加载器已经加载过，则子加载器无需再加载，保证被加载类的唯一性
     *
     *
     *  全盘负责委托机制
     *     当一个classLoader装载一个类时，该类依赖以及引用的类也由这个classLoader载入，除非指定使用另外一个classLoader
     *
     *
     *  打破双亲委派机制
     *       重写loadClass方法
     *
     */


    static {
        System.out.println("******************* load class ***********************");
    }

    public static void main(String[] args) {
        new A().a();
        System.out.println("***********************print main*******************");
        B b = null;
    }
}

class A {
    static {
        System.out.println("*******************load A*********************");
    }

    public A() {
        System.out.println("******************construct A*********************");
    }

    void a() {
        System.out.println("************************method a*******************");
    }
}

class B {
    static {
        System.out.println("*******************load B*********************");
    }

    public B() {
        System.out.println("******************construct B*********************");
    }
}
