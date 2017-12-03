package com.javabasic.java8.lambda;

import com.javabasic.java8.model.Robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Wentao Qian on 12/3/2017.
 * http://www.baeldung.com/java-8-streams
 */
public class StreamAPI {
    //Stream Creation
    private Stream<String> createEmptyStream() {
        Stream<String> stringStream = Stream.empty();
        return stringStream;
    }

    //Stream can also be created of any type of Collection (Collection, List, Set):
    private Stream<String> createStreamOfCollection() {
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> stringStream = collection.stream();

        //public interface List<E> extends Collection<E>
        List<String> list = Arrays.asList("a", "b", "c");
        return stringStream;
    }

    //Array can also be a source of a Stream
    private Stream<String> createStreamOfArray() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        return stringStream;
    }

    //Stream.generate()
    private Stream<Robot> generateStream() {
        Stream<Robot> stringStream =
                Stream.generate(()->{
                    Robot robot = new Robot(){{setID("x");}};//TODO
                    return robot;
                }).limit(10);
        return stringStream;
    }

    public static void main(String[] args) {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.generateStream();
    }

}
