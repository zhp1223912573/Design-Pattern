package Proxy.动态代理.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhp
 * @date 2022-08-22 15:08
 */
public class MyHanldeInvocation implements InvocationHandler {
    Object target;

    public MyHanldeInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始前");
        Object invoke = method.invoke(target, args);
        System.out.println("动态代理开始后");
        return invoke;
    }
}
