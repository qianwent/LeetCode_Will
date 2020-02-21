package com.book.algorithm4thedition.chapter2;

import java.util.Scanner;

public class In {

    private Scanner scanner;
    private String[] strings;

    public In() {
        scanner = new Scanner(System.in);
    }

    public String[] read() {
        String s = scanner.nextLine();
        strings = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            strings[i] = String.valueOf(s.charAt(i));
        }
        return strings;
    }

    public static void main(String[] args) {
        new In().read();
    }
}
