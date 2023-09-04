package com.test.dynamic;

/**
 * Author:   lxs
 * Date:     2022/5/12 11:08
 * Description: 静态代理测试
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建访问者对象
        ClothFactory neckTest = new NeckTest();

        //创建代理类对象
        ClothFactory personTest = new PersonTest(neckTest);

        personTest.produceCloth();
    }
}

/**
 * 委托类
 */
interface ClothFactory {

    void produceCloth();
}

/**
 * 代理类
 */
class PersonTest implements ClothFactory {

    private ClothFactory factory;

    //根据多态性质
    public PersonTest(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理类工作：造纸厂开始做一些准备工作");
        factory.produceCloth();
        System.out.println("代理类工作：造纸厂做一些后续收尾工作");
    }
}

/**
 * 被代理对象
 */
class NeckTest implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("造纸厂计划生产一批卫生纸");
    }
}

