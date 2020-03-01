package com.book.algorithm4thedition.chapter4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first; // top of the stack
    private int n; // size of the stack

    private static class Node<Item> {

        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    /**
     * FILO
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        }
        return first.item;
    }

    /**
     * 不想看到一个object的一串数字，就重写toString，感觉很多很基础的东西都不熟啊。。。
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : this) { // can do this.for because it implements Iterable, without Iterable, it would show compilation error
            sb.append(item);
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        /**
         * note: make sure to rewrite the logic, shouldn't return null
         */
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {

        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            /**
             * after running debug mode, it's clear that when loop through items(here it's this), even for getting first item,
             * it uses next() 不要想当然认为第一个element不是通过next而来，然后以为next就是返回next.item
             */
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        System.out.println(stack.first.item);
        System.out.println(stack);
    }
}
