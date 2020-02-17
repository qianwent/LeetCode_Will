package com.algorithm.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Wentao on 10/30/2017.
 */
public class InterviewTest2 {

     static void customSort(int[] arr) {

        Map<Integer, Integer> unsortedMap = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i]<1 || arr[i]>1000000) {
                System.out.println("error");
                return;
            }
            if(unsortedMap.containsKey(arr[i])) {
                Integer count = unsortedMap.get(arr[i]) + 1;
                unsortedMap.put(arr[i], count);
            } else {
                unsortedMap.put(arr[i], 1);
            }
        }

        unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .forEach(i-> {
                    for(int a=0; a<i.getValue(); a++) {
                        System.out.println(i.getKey());
                    }
                });

    }

    public static void main(String[] args) {
         int[] arr = {3,1,2,2,4};
         customSort(arr);
    }

}
