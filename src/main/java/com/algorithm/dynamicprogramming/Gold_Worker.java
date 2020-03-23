package com.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * https://www.jianshu.com/p/0d32d448ba15
 */
public class Gold_Worker {

    //g: gold quantity per jinkuang
    //p: people per jinkuang
    public static int getMostGold(int n, int w, int[] g, int[] p) {

        int[] preResults = new int[10];
        int[] results = new int[10];

        // set boarder line --- first line: one jinkuang, 0-w worker
        for (int i = 0; i < w; i++) {
            if (i < p[0] - 1) {
                preResults[i] = 0;
            } else {
                preResults[i] = g[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i]) {
                    results[j - 1] = preResults[j - 1];
                } else if (j == p[i]) {
                    results[j - 1] = Math.max(preResults[j - 1], preResults[0] + g[i]);
                } else {
                    results[j - 1] = Math.max(preResults[j - 1], preResults[j - p[i] - 1] + g[i]);
                }
            }
            //preResults = results;// share same array, if changes value in results, also change in preResults. so have to copy array
            preResults = Arrays.copyOf(results, 10);
        }
        return results[w - 1];
    }

    public static void main(String[] args) {
        System.out.println(getMostGold(5, 10, new int[]{400, 500, 200, 300, 350}, new int[]{5, 5, 3, 4, 3}));
    }
}
