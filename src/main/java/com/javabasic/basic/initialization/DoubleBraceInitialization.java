package com.javabasic.basic.initialization;

import com.javabasic.basic.model.Robot;

/**
 * Created by Wentao Qian on 12/3/2017.
 * https://stackoverflow.com/questions/1958636/what-is-double-brace-initialization-in-java
 * http://www.geeksforgeeks.org/anonymous-inner-class-java/
 */
public class DoubleBraceInitialization {
    public static void main(String[] args) {
        //���Լ�д�����ʱ�����û�ù�����д����ֻ��ѧϰ��ʱ�򿴵���anonymous inner class
        //���������ýӿڵ�ʱ��Ϊ�˷���������������µ�class
        /*
        ��������
        Thread t = new Thread(new Runnable()
        {
            public void run(){System.out.println("Child Thread");}
        });
        t.start();
         */
        //���������������£���ʼһ����һ����constructor
        Robot robot0 = new Robot("abc");
        //����������д�����������һЩǱ�����⣬����ο���һ��Stack Overflow�Ĵ�
        //��Ϊ�����new��anonymous class�����ܻ����ĳЩ����µ�memory leak��GC��serialising������
        Robot robot = new Robot(){{setID("abc");}};

        /*
        ��������ò�Ҫ��{{}}���������𲻱�Ҫ���鷳��
        ����memory leak���ҹ���֮ǰ������һ����Ŀ��memory leak������Ϊ����д����ɵģ���ʱ��ÿ��һ��ʱ�䣬���ܼ���
        �ڴ�ռ�þʹﵽһ���ߵ㣬����Ҫ��������Ȼ����Ҳֻ���ǲ²��ˣ��Ժ������������⣬���Գ����Ų�����д����trouble shooting��
         */
    }
}
