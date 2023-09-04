package com.test.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:   lxs
 * Date:     2022/5/12 11:17
 * Description: 动态代理测试
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        //创建被代理的实例对象
        Person renter = new Renter();

        //代理对象的调用处理程序，我们将要被代理的真实对象传入代理对象的调用处理的构造函数中，最终代理对象的调用处理程序会调用真实对象的方法
        InvocationHandler renterHandler = new RenterInvocationHandler<>(renter);

        Person renterProxy = (Person) Proxy.newProxyInstance(renterHandler.getClass().getClassLoader(), renter.getClass().getInterfaces(), renterHandler);
        renterProxy.rentHouse();
    }
}

/**
 * 委托类
 */
interface Person {

    void rentHouse();

}

/**
 * 被代理类
 */
class Renter implements Person {
    @Override
    public void rentHouse() {
        System.out.println("租客租房成功！");
    }
}

class RenterInvocationHandler<T> implements InvocationHandler {

    //被代理类的对象
    private T target;

    public RenterInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * @param proxy  动态代理对象
     * @param method 正在执行的方法
     * @param args   调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在真实的对象执行之前我们可以添加自己的操作
        System.out.println("租客和中介交流");
        Object invoke = method.invoke(target, args);
        //在真实的对象执行之后我们可以添加自己的操作
        System.out.println("租客付款给中介");
        return invoke;
    }
}