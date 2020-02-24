package com.jdk.learning;

import java.util.HashMap;
import java.util.Map;

public class JDKHashMap {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("a", "abc");
        map.put("b", "bcd");
        map.put("c", "cde");
        map.get("c");

        Person p1 = new Person("1", "aaa");
        /**
         * with or without overriding hashCode, the two objects equals because equals method already overrode
         */
        Person p2 = new Person("1", "bbb");
        System.out.println(p1.equals(p2));
        Map<Person, String> map1 = new HashMap<>();
        map1.put(p1, "test");
//        map1.put(p2, "test");
        /**
         * without overriding hashCode method, and run into getNode in HashMap
         * hash for p1 is 1612791503, (n - 1) & hash = 15, tab[(n - 1) & hash] has p1 object
         * hash for p2 is 1286100471, (n - 1) & hash = 7, tab[(n - 1) & hash] is null
         *
         * with overriding hashCode method
         * hash for p1 is 1, (n - 1) & hash = 1, tab[(n - 1) & hash] has p1 object
         * hash for p2 is 1, (n - 1) & hash = 1, tab[(n - 1) & hash] has p2 object
         */
        System.out.println(map1.get(p1));
        System.out.println(map1.get(p2));
        /**
         * without overriding hashCode, p2 couldn't be found in map1
         * 还可以理解为，没有重写hashcode，p2实际上就没有被放入map1中
         * 重写之后，p1!=p2，特别注意，这个时候p2这个object并没有被put到map1中，而是因为基于hashmap getNode里的算法
         * 只要hashCode一致，就可以找到p1，然后把p1对应的value拿出来
         */
        System.out.println(p1 == p2);
        System.out.println(map1.containsKey(p2));
    }

    private static class Person {
        private String id;
        private String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(id);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Person) {
                return this.getId() == ((Person) obj).getId();
            }
            return false;
        }
    }
}
