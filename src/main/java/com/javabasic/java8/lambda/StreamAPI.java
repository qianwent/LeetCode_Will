package com.javabasic.java8.lambda;

import com.javabasic.basic.model.Robot;

import java.util.*;
import java.util.stream.Collectors;
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
//                    Robot robot = new Robot(){{setID("x");}};//this is not a good practice
                    Robot robot = new Robot("abc");
                    return robot;
                }).limit(10);
        return stringStream;
    }

    //intermediate operations, terminal operation
    public void referencingStream() {
        Stream<String> stream = Stream.of("a", "b", "c").filter(e->e.contains("c"));
        Optional<String> element = stream.findAny();

        List<String> list = Stream.of("a", "b", "c").filter(e->e.contains("c")).collect(Collectors.toList());
        Optional<String> element1 = list.stream().findAny();
    }

    //stream.map
    public static void streamMap() {
        Stream<Robot> robotStream = Stream.of("a", "b", "c").map(e->new Robot(e));
        robotStream.forEach(Robot::reportID);
    }

    //different ways to collect
    public static void collectMethod1() {
        //下面这种写法是错误的！
//        List<Robot> robotList = new ArrayList<>(new Robot("a"), new Robot("b"), new Robot("c"));
        //这是最普通的写法
        List<Robot> robotList0 = new ArrayList<>();
        robotList0.add(new Robot("a"));
        //这个Arrays.asList的写法要记住，应该是比较通用的方法
        List<Robot> robotList = Arrays.asList(new Robot("a"), new Robot("b"), new Robot("c"));
        List<String> nameList = robotList.stream().map(robot -> robot.generateRobotName()).collect(Collectors.toList());
        System.out.println(nameList);
        /*Set<Robot> robotSet = new HashSet<>();
        robotSet.add(new Robot("a"));
        robotSet.add(new Robot("b"));
        robotSet.add(new Robot("b"));*/
        //下面这种方法，比较有意思，至于那种好，需要实战 TODO
        //https://stackoverflow.com/questions/2041778/how-to-initialize-hashset-values-by-construction
        Set<Robot> robotSet = new HashSet<>(Arrays.asList(new Robot("a"), new Robot("b"), new Robot("c")));
        Set<String> stringSet = robotSet.stream().map(robot -> robot.generateRobotName()).collect(Collectors.toSet());
        System.out.println(stringSet);
    }

    public static void collectMethod2() {
        List<Robot> robotList = Arrays.asList(new Robot("a", "001"),
                new Robot("b", "001"), new Robot("c", "002"));
        Map<String, List<Robot>> map = robotList.stream().collect(Collectors.groupingBy(Robot::getType));
        System.out.println(map);
        Map<Boolean, List<Robot>> map2 = robotList.stream()
                .collect(Collectors.partitioningBy(r->r.getType().equals("001")));
        System.out.println(map2);
    }

    public static void main(String[] args) {
        StreamAPI streamAPI = new StreamAPI();
        streamAPI.generateStream();

        streamMap();

        collectMethod1();
        collectMethod2();
    }

}
