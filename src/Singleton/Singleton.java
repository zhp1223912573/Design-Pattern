package Singleton;

/**
 * @author zhp
 * @date 2022-08-21 2:47
 */

import jdk.nashorn.internal.parser.Scanner;

import java.security.Signature;

/**单列模式实现
 * 使用意义：
 *  通过保证系统中只存在一个单例对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单列可以提升系统性能。
 * 使用场景：
 *  需要频繁进行创建和销毁的对象，创建对象耗时过多和资源消耗过多（重量级对象）。经常用到的对象，工具类对象，
 *  频繁访问数据库或文件的对象。
 *
 *
 */
public class Singleton {

    /** 饿汉式
     * 在类被加载时实例instance就被加载。
     * 优点：实现简单，无须额外的同步操作，线程安全
     * 缺点：如果类的单列始终不被使用，则浪费了内存
     */
    //1.直接初始化
    private static Singleton instance = new Singleton();
    //2.与第1种没什么区别
//    private static Singleton instance = null;
//    static {
//        instance = new Singleton();
//    }
    private Singleton(){

    }
//    public static Singleton getInstance(){
//        return instance;
//    }


    /**懒汉式
     * 在调用getInstance函数时才创建单例
     * 优点：节约内存，只有使用getInstance时才创建单列
     */
    /*非同步
    缺点：只能在单线程环境下使用，多线程环境会创建多个实例*/
//    public static Singleton getInstance(){
//        if(instance==null){
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /*同步方法
    相比上面一个方法，可以在多线程环境下进行，但每次执行getinstance时都需要同步，开销大，开发中使用的较少*/
//    public static synchronized  Singleton getInstance(){
//        if(instance==null){
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**双重检查
     *
     * 线程安全，延迟加载，效率较高，开发中常用
     */
//    public static synchronized  Singleton getInstance(){
//        if(instance==null){
//            synchronized (Singleton.class){
//                if(instance==null){
//                    instance  = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }


    /**静态内部类
     *静态内部类在Sigleton被加载时不会实例化，只有在调用getInstance方法使用到静态内部类时
     * 才首次被加载，从而完成instance的实例化。
     */
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static synchronized Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }

    /**枚举
     *不仅能避免线程同步问题，而且还能防止反序列化重建对象
     */
    enum singleton{
        INSTANCE;
        public void sayHi(){
            System.out.println("HI");
        }
    }

    public static void main(String[] args) {
        Singleton instance = getInstance();
        System.out.println(instance);
        singleton singleton = Singleton.singleton.INSTANCE;
        singleton.sayHi();
    }

}
