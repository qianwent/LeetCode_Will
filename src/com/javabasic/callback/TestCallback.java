package com.javabasic.callback;

/**
 * Created by Wentao Qian on 1/24/2018.
 */
public class TestCallback {

    /*
    ������⣬������ڶ��߳�ͬ��
    ���߳�ͬ������������������ճ�����ĳ�����A��B���಻�õȴ�������2���̣߳�����ִ�У����������
    ���˼·�Ƿǳ�������
    ���Ƿŵ�JavaScript���棬�Ͳ�����ô����
    JavaScript�ǵ��̵߳ģ�ע�⣬����˵���߳̾�һ�����첽�ģ�����������������ǲſ����õ��첽
     */

    public static void main(String[] args) {
        B b = new B();

        A a = new A(b);

        a.call("1+1=?");
    }

}
