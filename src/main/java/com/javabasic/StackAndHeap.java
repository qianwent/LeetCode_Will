package com.javabasic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wentao Qian on 11/26/2017.
 */
public class StackAndHeap {
    /*
        дJava��ô��ʱ�䣬����֪��StackOverflow����ģ���ô���ھ����ܽ�һ�£�Stack������ݽṹ
        ����һ�����ݽṹ
        Last in, first out��LIFO
        �����ֽṹ���׵ģ���һЩ�ض��ķ�������ҪΪ������Щ��
        push�������������ݡ�
        pop�����ز��Ƴ��������ݡ�
        top������������ݵ�ֵ�������Ƴ�����
        isempty������һ������ֵ����ʾ��ǰstack�Ƿ�Ϊ��ջ��
        ��������������з�ʽ
        stack�ĵڶ��ֺ�����"����ջ"��call stack������ʾ��������������ѻ�ľһ����ţ���ʵ�ֲ����á�
        ���������ڴ�����
        stack�ĵ����ֺ����Ǵ�����ݵ�һ���ڴ����򡣳������е�ʱ����Ҫ�ڴ�ռ������ݡ�
        һ����˵��ϵͳ�Ữ�ֳ����ֲ�ͬ���ڴ�ռ䣺һ�ֽ���stack��ջ������һ�ֽ���heap���ѣ���
        ���ǵ���Ҫ�����ǣ�stack���нṹ�ģ�ÿ�����鰴��һ�������ţ�������ȷ֪��ÿ������Ĵ�С��
        heap��û�нṹ�ģ����ݿ��������š���ˣ�stack��Ѱַ�ٶ�Ҫ����heap��
        �����������У�һ����˵��ÿ���̷߳���һ��stack��ÿ�����̷���һ��heap��
        Ҳ����˵��stack���̶߳�ռ�ģ�heap���̹߳��õġ����⣬stack������ʱ�򣬴�С��ȷ���ģ����ݳ��������С��
        �ͷ���stack overflow���󣬶�heap�Ĵ�С�ǲ�ȷ���ģ���Ҫ�Ļ����Բ������ӡ�
        ����������Щ�������ݴ�ŵĹ����ǣ�ֻҪ�Ǿֲ��ġ�ռ�ÿռ�ȷ�������ݣ�һ�㶼�����stack���棬����ͷ���heap���档
     */
    //һ����˵��StackOverflow�����׵�ʵ�ַ�ʽ��recursion
    private static void method() {
//        System.out.println("method");
        method();//Exception in thread "main" java.lang.StackOverflowError
    }

    public static void main(String[] args) {
        method();

        //������OutOfMemoryErrorǰ����Ҫ����VM Args: -Xms20m -Xmx20m (���ƶѵĴ�С������չ)
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        List<Object> list=new ArrayList<>();
        // ���ϴ������󣬲���֤GC Roots������֮���пɴ�·������������������������Ķ���
        while (true) {
            list.add(new OOMObject());
//            System.out.println(System.currentTimeMillis());
        }
    }

    public static class OOMObject {
    }
}
