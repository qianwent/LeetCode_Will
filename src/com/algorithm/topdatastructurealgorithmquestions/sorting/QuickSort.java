package com.algorithm.topdatastructurealgorithmquestions.sorting;

/**
 * Created by Wentao Qian on 12/4/2017.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {49,37,65,97,76,13,27,49,78};
        quickSort(arr, 0, arr.length-1);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    //divide and conquer
    private static void _quickSort(int[] arr, int left, int right) {
        if(left<right) {
            int mid = _getMiddle(arr, left, right);
            _quickSort(arr, left, mid-1);
            _quickSort(arr, mid+1, right);
        }
    }

    //看这个取中间值的过程，不仅仅是取一个中间值，取出来之后的第一轮排序已经开始，即左指针和右指针分别移动到
    //比中间值大和小的数，进行第一次位置的对调，这看起来也是分治法每一小步中很关键的部分，即处理一小部分---现在想来，
    //更理解了这个分治法的思想，把一个任务分到不能分为止，然后用这些最小任务的结果整合起来，就变成大的任务 ---
    //等等，以前学算法的时候为什么不能很好的理解？因为即使让一个没学过算法的人来看上面一行的思想，肯定是不能理解的
    //因为这样的解释跳过了很关键的步骤，即递归调用，在上面的_quickSort方法中，我们需要一遍一遍递归，直到到达最小任务，
    // 即任务不能再分割，也就是说，这个最小任务在这个算法里面，必须要保证至少有2个数可以排序，如果只有一个，
    // 就不用进入_quickSort方法了。
    //TODO:所以说啊，学算法，得实战，光看理论以我的理解能力和思路是不可能看懂的！
    private static int _getMiddle(int[] arr, int left, int right) {
//        int _left = left;//一开始这里把左右指针保存起来了，这个是借鉴cleanerversion里的，
            // 但是这里我们把一个方法分解多个方法了，左右指针会传递到下一个方法里，所以这里就不用保存了
//        int _right = right;
        int temp = arr[left];//这个就是基准，一般取最左边的
        while(left < right) {
            //TODO:一开始写成了arr[right]>temp，也显然不对了，就比如main方法里的array，有两个49，指针应该继续移动
            while(left<right && arr[right]>=temp) {
                right--;
            }
            arr[left] = arr[right];
            while(left<right && arr[left]<=temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        /*
        这里一开始写反了，想当然了，一定注意，我们一直在操作这个array
        选完最左边的数作为基准之后，在第一轮结束的时候，这个基准数（除非碰巧是最大或最小）将移动到所谓的“中间位置”，
        这个中间位置是一个相对中间的位置，即左边的都比中间值小，右边的都比中间值大，但是左边任然是乱序，右边同理。
        所以最后输出的这个中间值，应该是放到右指针或者左指针移动之后空出来的位置，而这一轮中间值就是一开始去的temp的值。
        （具体过程可以对照https://www.cnblogs.com/MOBIN/p/4681369.html里的图，会比较清晰）
        特别注意：上面的外层while loop里面，别看还套着2层while loop，其实就是简单的2个数对调位置（这里面有一些情况
        可能会比较绕，但是绕过一次就清楚了，下次就有思路了，比如如果array里有2个相邻的相等的数，那在这个while循环里，
        两者可能会对调位置，如[6,1,3,7,3]且基准元素为6时，经过分区，形成[1,3,3,6,7],两个3的相对位置发生了改变。
        进一步理解：极限情况，如果是逆序的，那就是最差情况，移动次数达到最大值; 如果已经是排好序的，
        那么最左最终还是最左，最右还是最右，但是发现，这还是最差情况，array虽然没有变，但是每个元素都被遍历了一遍，
        时间复杂度依旧是O(n^2)）
         */
//        temp = arr[_right];
        arr[right] = temp;
//        return temp;//一开始写成了这个，那显然不对了，left和right永远都是指针，即index，传这个位置的数就不对了
        return right;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(arr.length>0) {
            _quickSort(arr, left, right);
        }
    }
}
