package com.algorithm.topdatastructurealgorithmquestions.sorting;

/**
 * Created by Wentao Qian on 12/6/2017.
 */
public class InsertionSorting {
    /*
    原理很简单，但是真要写代码确实花了一番功夫去理解
    首先第一个元素不动，然后每一次大循环都是把这个第i个元素插入到之前已经排好序的队伍当中
    怎么能使得这个元素插入之后序列仍然正确，那就要从后往前再遍历一遍
    有了这个思路，剩下的就是判断好arr[j+1] = arr[j];arr[j+1] = temp;这样的逻辑了
    比如最后为什么又是arr[j+1] = temp;因为之前循环里的arr[j+1] = arr[j];一直是在跟temp做比较
    这个时候得有点想象力了，想象队列里，一旦arr[j+1] = arr[j]被执行，意味着temp的位置被arr[j]取代
    而此时，原本arr[j]的位置依然是其本身，但得想象成空出来了，temp必须要填补这个空缺，这个空缺又不用立刻填补
    因为前面的数字还要和temp比，如果temp还是小，前面的数还得往后退，直到内循环条件不满足，
    这个时候，temp位置锁定，本来应该是j，但是最后j--，需要把j还原，所以变成了arr[j+1] = temp;
    TODO：插入排序原理上很好理解，但是写代码这是第一次，得记住
    时间复杂度依旧是O(n^2)
     */
    public static void insertionSorting(int[] arr) {
        int temp, i, j, n=arr.length;
        //看这个外循环，和bubble sort一样，都是循环n-1次
        for(i=1; i<n; i++) {
            temp = arr[i];
            for(j=i-1; j>=0&&arr[j]>temp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        insertionSorting(arr);
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
