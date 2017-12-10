package com.algorithm.topdatastructurealgorithmquestions;

/**
 * Created by Wentao Qian on 12/4/2017.
 * refer to com.javabasic.basic.nestedclass.NestedClassDemo
 * basic knowledge of nested static class
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = linkedList.head();
        linkedList.add( new LinkedList.Node("1"));
        linkedList.add( new LinkedList.Node("2"));
        linkedList.add( new LinkedList.Node("3"));
        linkedList.add( new LinkedList.Node("4"));
//        linkedList.add( new LinkedList.Node("5"));

        //finding middle element of LinkedList in single pass
        LinkedList.Node current = head;
        int length = 0;
        LinkedList.Node middle = head;

        //����㷨�ľ��裬ʵ����Ҳ�Ǻܼ򵥣����Ƕ��겻����ô�򵥵���ѧ���ˡ�����
        //middleָ��ÿ�ƶ�һ�Σ�currentָ��ͻ��ƶ�2�Σ����������
        //���ⲻ�ͱ��Сѧ��ѧ���ˣ�һ�����ֵ���λ��=(n+1)/2 if n��������=n/2 if n��ż��
        //������㷨�У�����custom��LinkedList��û��index�ģ�ֻ�ж�����next��������ֻ�ܶ�̬������middle
        //����˵ʵ���������ż�����Ļ�����λ���͵���Ϊ�����ˣ�������Ϊ�ⲻ����һ���õ����ݽṹ��
        while(current.next() != null){
            length++;
            if(length%2 ==0){
                middle = middle.next();
            }
            current = current.next();
        }

        if(length%2 == 1){
            middle = middle.next();
        }

        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + middle);

    }
}

//custom LinkedList for demo
class LinkedList{
    private Node head;
    private Node tail;

    public LinkedList(){
        //��ʼ����ʱ��ȷ���и�head
        this.head = new Node("head");
        //���ҽ������head������tail��headʵ������ͬһ���ڵ�
        tail = head;
    }

    public Node head(){
        return head;
    }

    public void add(Node node){
        tail.next = node;
        tail = node;
    }

    public static class Node{
        private Node next;
        private String data;

        public Node(String data){
            this.data = data;
        }

        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString(){
            return this.data;
        }
    }
}