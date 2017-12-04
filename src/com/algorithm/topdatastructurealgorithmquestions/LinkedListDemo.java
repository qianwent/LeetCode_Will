package com.algorithm.topdatastructurealgorithmquestions;

/**
 * Created by Wentao Qian on 12/4/2017.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = linkedList.head();
        linkedList.add( new LinkedList.Node("1"));
        linkedList.add( new LinkedList.Node("2"));
        linkedList.add( new LinkedList.Node("3"));
        linkedList.add( new LinkedList.Node("4"));
        linkedList.add( new LinkedList.Node("5"));

        //finding middle element of LinkedList in single pass
        LinkedList.Node current = head;
        int length = 0;
        LinkedList.Node middle = head;

        //这个算法的精髓，实际上也是很简单，真是多年不做这么简单的数学题了。。。
        //middle指针每移动一次，current指针就会移动2次，这就是特性
        //那这不就变成小学数学题了，一串数字的中位数=(n+1)/2 if n是奇数，=n/2 if n是偶数
        //在这个算法中，我们custom的LinkedList是没有index的，只有定义了next方法，那只能动态地设置middle
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
        this.head = new Node("head");
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