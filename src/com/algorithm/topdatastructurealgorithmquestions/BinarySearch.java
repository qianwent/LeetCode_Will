package com.algorithm.topdatastructurealgorithmquestions;

/**
 * Created by Wentao Qian on 12/19/2017.
 * http://www.geeksforgeeks.org/binary-search/
 *
 * time complexity:
 * binary search only works with sorted array list, theoretically
 * so if we only talk about binary search a sorted array list, then O(n) = logn;
 * however, if it's not sorted, then we should sort it first, O(n) = nlogn , (if we use a sorting algorithm with nlogn)
 */
public class BinarySearch {
    // Returns index of x if it is present in arr[], else
    // return -1
    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r)
        {
            //https://www.zhihu.com/question/20101702/answer/13978993
//            int m = l + (r-l)/2;
            int m = (l + r) >>> 1;
            /*
            >>>与>>是位运算符，只对整型有效（不能用于浮点型）。 当是整型的时候(low+high)>>1可以代替(low+high)/2。
            >>>是无符号右移运算符。如果 low+high是正整数，这三种运算是等价的。
            由于有编译器优化，他们的效率应该是相同的（如果不存在编译器优化，移位运算更快）
             */

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was not present
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "+result);
    }
}
