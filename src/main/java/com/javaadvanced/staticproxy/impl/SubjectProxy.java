package com.javaadvanced.staticproxy.impl;

import com.javaadvanced.staticproxy.Subject;

/**
 * Created by Wentao Qian on 5/20/2018.
 * ����Ȼ�Ǻܹ��ϵ�������ֻ���ں�С����Ŀ���á���ʵ������ǣ�������ô���ܻ�����ôС����Ŀ��
 * ���ڵĴ�����Ŀ��ĵ��д󹤳̵����������ô�ܳ�֮Ϊ��������أ�
 */
public class SubjectProxy implements Subject {

    private Subject subject;

    public SubjectProxy() {
        subject = new SubjectImpl();
    }

    @Override
    public void method1() {
        before();
        subject.method1();
        after();
    }

    private void before() {
        System.out.println("before method, do some logic...");
    }

    private void after() {
        System.out.println("after method, do some logic...");
    }

    public static void main(String[] args) {
        SubjectProxy subjectProxy = new SubjectProxy();
        subjectProxy.method1();
    }

}
