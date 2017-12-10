package com.javabasic.basic.nestedclass;

/**
 * Created by Wentao Qian on 12/10/2017.
 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 */
public class CallNestedClass {
    public static void main(String[] args) {
        /*
        Why Use Nested Classes?

            Compelling reasons for using nested classes include the following:

            It is a way of logically grouping classes that are only used in one place:
            If a class is useful to only one other class,
            then it is logical to embed it in that class and keep the two together.
            Nesting such "helper classes" makes their package more streamlined.

            It increases encapsulation: Consider two top-level classes, A and B,
            where B needs access to members of A that would otherwise be declared private.
            By hiding class B within class A, A's members can be declared private and B can access them.
            In addition, B itself can be hidden from the outside world.

            It can lead to more readable and maintainable code: Nesting small classes
            within top-level classes places the code closer to where it is used.
         */
        NestedClassDemo.StaticNestedClass staticNestedClass = new NestedClassDemo.StaticNestedClass("test");
        //it's different to initialize static nested class and inner class(non-static)
        NestedClassDemo outerClass = new NestedClassDemo();
        NestedClassDemo.InnerClass innerClass = outerClass.new InnerClass();
    }
}
