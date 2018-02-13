package com.javabasic.basic.immutable;

import java.util.Date;

/**
 * Created by Wentao Qian on 2/13/2018.
 *
 * https://softwareengineering.stackexchange.com/questions/151733/if-immutable-objects-are-good-why-do-people-keep-creating-mutable-objects
 * 先看下这里的回答，可以看出immutable object开销肯定是大的，但是能避免多线程带来的问题
 * 但是一般web APP如果没有什么多线程的话，显然是没必要用immutable的，就像spring容器里都是单例一样
 * 每个object一般没有什么私有属性(不是那些autowire出来的)，通常web容器里的多个线程看到同一个object的时候
 * 都会把里面的方法进行copy，可以想象如果整个object都要一次次地copy，那开销得多大啊
 * 目前看来，还没有碰到什么非要用immutable的场景，做的还是不够多啊。。。
 *
 * https://my.oschina.net/jackieyeah/blog/205198?fromerr=yJ78hGIV
 *
 * Planet是一个不可变类，因为当它构造完成之后没有办法改变它的状态
 */
public class Planet {

    /**
     * 声明为final的基本类型数据总是不可变的
     */
    private final double fMass;
    /**
     * 不可变的对象属性 (String对象不可变)
     */
    private final String fName;
    /**
     * 可变的对象属性. 在这种情况下, 这个可变属性只能被这个类改变。
     * (在其它情况下, 允许在原生类外部改变一个属性是很有意义的;
     * 这种情况就是当属性作为其它地方创建的一个对象引用)
     */
    private final Date fDateOfDiscovery;
    public Planet(double aMass, String aName, Date aDateOfDiscovery) {
        fMass = aMass;
        fName = aName;
        //创建aDateOfDiscovery的一个私有拷贝
        //这是保持fDateOfDiscovery属性为private的唯一方式, 并且保护这个
        //类不受调用者对于原始aDateOfDiscovery对象所做任何改变的影响
        fDateOfDiscovery = new Date(aDateOfDiscovery.getTime());
    }
    /**
     * 返回一个基本类型值.
     *
     * 调用者可以随意改变返回值,但是不会影响类内部。
     */
    public double getMass() {
        return fMass;
    }
    /**
     * 返回一个不可变对象
     *
     * 调用者得到内部属性的一个直接引用. 由于String是不可变的所以没什么影响
     */
    public String getName() {
        return fName;
    }
// /**
// * 返回一个可变对象 - 不是一个好的方式.
// *
// * 调用者得到内部属性的一个直接引用. 这通常很危险,因为Date对象既可以
// * 被这个类改变也可以被它的调用者改变.即,类不再对fDate拥有绝对的控制。
// */
// public Date getDateOfDiscovery() {
// return fDateOfDiscovery;
// }
    /**
     * 返回一个可变对象 - 好的方式.
     *
     * 返回属性的一个保护性拷贝.调用者可以任意改变返回的Date对象,但是不会
     * 影响类的内部.为什么? 因为它们没有fDate的一个引用. 更准确的说, 它们
     * 使用的是和fDate有着相同数据的另一个Date对象
     */
    public Date getDateOfDiscovery() {
        return new Date(fDateOfDiscovery.getTime());
    }
    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        Planet planet = new Planet(1.0D, "earth", new Date());
        Date date = planet.getDateOfDiscovery();
        date.setTime(111111111L);
        System.out.println("the value of fDateOfDiscovery of internal class : " + planet.fDateOfDiscovery.getTime());
        System.out.println("the value of date after change its value : " + date.getTime());
    }

}
