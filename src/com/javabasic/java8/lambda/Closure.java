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
        /*
        ע��������ָlocal variable
        Any local variable, formal parameter, or exception parameter used but not declared in a lambda expression must
        either be declared final or be effectively final (��4.12.4),
        or a compile-time error occurs where the use is attempted.

        It is worth mentioning that, anonymous classes can access only final local variables (in JAVA SE 7),
        while in Java SE 8 you can access effectively final variables also inside lambda as well as inner classes.
         */
        int i = 0;
//        i = 1;
        Supplier<Integer> supplier = () -> i;
        /*����Java�бհ��Ĵ�ǳ��⣬������js�У��ܹ�ֱ�Ӻ���Ƕ�׺���(ע�������ڶ����ʱ��)��
        �����﷨��Ƶ�ʱ�����������
        ����Ҫע���������ԵĲ�ͬ��Java�ǻ�����ģ������ٶ������������ԣ�����Ҳ���������
        ����js�У�function�Ǿ���һ��variable����ô���
        https://stackoverflow.com/questions/7295634/javascript-nested-function
        �ο�������Ļش�
        Ȼ���ٿ��������
        http://skilldrick.co.uk/2010/11/a-brief-introduction-to-closures/
        �����more advanced example���ǲ��Ǻ���Java���������������أ��ǵģ�������function�������࣬
        �ڲ��function������������ԣ���������еı�������instance variable�����ڲ��������ܵ��������Ա������
        ���ٻص�supplier������ӣ�������ô��⣬Java�еıհ�������Ҫ����Ϊһ��wrapper����֧�ֵ�
        lambda�������һ��������ʵ�֣����ʺ�anonymous class��һ�µģ�����Java���������͸������ˣ�
        �ڲ�����ķ���Ҫ���õ�������������effectively final�ģ��漰һЩ�����ε�����
        �����https://stackoverflow.com/questions/4732544/why-are-only-final-variables-accessible-in-anonymous-class
        https://www.zhihu.com/question/21395848 �������֪���Ľ��������һЩ��������Ȼ�е�ֽ��̸������˼
        �Ͼ�ĿǰΪֹʵս���õ������ڲ����lambda�е����ⲿvariable�����д�Ļ��ǱȽ��� TODO
         */

        Closure closure = new Closure();
        closure.r.run();

        closure.s1(closure.s2("a", "b"));

    }

    /*
    �ٿ���������ӣ�ii��instance variable�������������������
     */
    int ii=10086;
    Runnable r = () -> {
        seti();
        System.out.print(ii);
    };
    void seti(){
        this.ii++;
    }

    public String s1(String s) {
        return s2(s, "c");
    }

    public String s2(String a, String b) {
        return a + b;
    }

}
