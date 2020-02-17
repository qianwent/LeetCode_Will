package com.javaadvanced.staticproxy.impl;

import com.javaadvanced.staticproxy.Subject;

/**
 * Created by Wentao Qian on 5/20/2018.
 * 这显然是很古老的做法，只能在很小的项目里用。但实际情况是，现在怎么可能还有这么小的项目。
 * 现在的大型项目真的得有大工程的理念，否则怎么能称之为软件工程呢？
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
