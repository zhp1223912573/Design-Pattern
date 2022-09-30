package Proxy.动态代理.jdk;

import java.lang.reflect.Proxy;

/**
 * @author zhp
 * @date 2022-08-22 14:44
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory factory = new ProxyFactory(teacherDao);
        //1.直接将创建代理对象的过程封装在factory内部
        ITeacherDao proxyInstance =(ITeacherDao) factory.getProxyInstance();
        proxyInstance.teacher();
        proxyInstance.sayHello("pengge");

        //2.常规方法，实现InnovationHandler接口的自定义类，在类内重写invoke方法，加强逻辑，实际调用代理对象使，注入执行的方法
        ITeacherDao o = (ITeacherDao) Proxy.newProxyInstance(teacherDao.getClass().getClassLoader(), teacherDao.getClass().getInterfaces()
                , new MyHanldeInvocation(teacherDao));
        o.teacher();
        o.sayHello("nihao");

    }
}
