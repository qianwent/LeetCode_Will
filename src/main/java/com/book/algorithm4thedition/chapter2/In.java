package com.book.algorithm4thedition.chapter2;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class In {

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

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

    public String readAll() {
        return scanner.nextLine();
    }

    public String[] readAllStrings() {
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        return tokens;
    }

    public int[] readAllInts() {
        String[] fields = readAllStrings();
        int[] vals = new int[fields.length];
        for (int i = 0; i < fields.length; i++) {
            vals[i] = Integer.parseInt(fields[i]);
        }
        return vals;
    }

    public int readInt() {
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from the input stream, "
                    + "but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from the input stream, "
                    + "but no more tokens are available");
        }
    }

    public static void main(String[] args) {
        new In().read();
    }
}
