package com.javabasic.java8.lambda;

import java.util.function.Supplier;

/**
 * Created by Wentao Qian on 1/17/2018.
 * ��Java�бհ���˼����Դ�Ը�ϰJavaScript�еıհ�����Ϊ��Ū����հ�������ʲô���ã�ΪʲôJavaд����ô��
 * ȴ�ƺ�û�������������Ǻ����ˣ��������û�У���Ҫһ̽����
 * https://www.zhihu.com/question/63548795
 * ���֪����������һЩ���룬��������һ�£�������������������е㸴�ӡ�����
 */
public class Closure {

    public static void main(String[] args) {
        int i = 0;
//        i = 1;
        Supplier<Integer> supplier = () -> i;

        Closure closure = new Closure();
        closure.r.run();

    }

    int ii=10086;
    Runnable r = () -> {
        seti();
        System.out.print(ii);
    };
    void seti(){
        this.ii++;
    }

}
