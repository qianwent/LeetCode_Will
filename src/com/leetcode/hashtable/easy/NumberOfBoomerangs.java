package com.leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wentao on 5/3/2017.
 *
 * 447. Number of Boomerangs
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

 Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberOfBoomerangs {

    public static void main(String args[]) {

        //tuple of points (i, j, k) 限定了这个boomerang是一个三元的，现在想来也是，如果不限定三元，那看起来没什么意义
//        int[][] points = {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
        int[][] points = {{0,0}, {1,0}, {-1,0}};
        int r = numberOfBoomerangs(points);
        System.out.println(r);

    }

    public static int numberOfBoomerangs(int[][] points) {

        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i==j) continue;
                int distance = getDistance(points[i], points[j]);
                // 只有三个点的话，看起来逻辑还是太简单了点，以下这个方法用了一个规律性的特性：
                // 如果第一个点和第二第三个点之间的距离相等，那么第二第三个点的顺序可以颠倒，则相当于两组结果
                // 而这样的算法，每次只会计算两个距离，也就是说val永远不会超过2
                // 所以，限定在本题的意思内，该解法可行，如果把数组拓展成3+维数组，则该解法失去意义
                map.put(distance, map.getOrDefault(distance,0) + 1);
            }
            for(int val : map.values()) {
                result += val * (val-1);
            }
            map.clear();
        }

        return result;

    }

    private static int getDistance(int[] point1, int[] point2) {
        int dx = point1[0] - point2[0];
        int dy = point1[1] - point2[1];
        return dx*dx + dy*dy;
    }

}
