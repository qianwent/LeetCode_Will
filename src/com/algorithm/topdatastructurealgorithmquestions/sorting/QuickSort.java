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

    //�����ȡ�м�ֵ�Ĺ��̣���������ȡһ���м�ֵ��ȡ����֮��ĵ�һ�������Ѿ���ʼ������ָ�����ָ��ֱ��ƶ���
    //���м�ֵ���С���������е�һ��λ�õĶԵ����⿴����Ҳ�Ƿ��η�ÿһС���кܹؼ��Ĳ��֣�������һС����---����������
    //�������������η���˼�룬��һ������ֵ����ܷ�Ϊֹ��Ȼ������Щ��С����Ľ�������������ͱ�ɴ������ ---
    //�ȵȣ���ǰѧ�㷨��ʱ��Ϊʲô���ܺܺõ���⣿��Ϊ��ʹ��һ��ûѧ���㷨������������һ�е�˼�룬�϶��ǲ�������
    //��Ϊ�����Ľ��������˺ܹؼ��Ĳ��裬���ݹ���ã��������_quickSort�����У�������Ҫһ��һ��ݹ飬ֱ��������С����
    // ���������ٷָҲ����˵�������С����������㷨���棬����Ҫ��֤������2���������������ֻ��һ����
    // �Ͳ��ý���_quickSort�����ˡ�
    //TODO:����˵����ѧ�㷨����ʵս���⿴�������ҵ����������˼·�ǲ����ܿ����ģ�
    private static int _getMiddle(int[] arr, int left, int right) {
//        int _left = left;//һ��ʼ���������ָ�뱣�������ˣ�����ǽ��cleanerversion��ģ�
            // �����������ǰ�һ�������ֽ��������ˣ�����ָ��ᴫ�ݵ���һ���������������Ͳ��ñ�����
//        int _right = right;
        int temp = arr[left];//������ǻ�׼��һ��ȡ����ߵ�
        while(left < right) {
            //TODO:һ��ʼд����arr[right]>temp��Ҳ��Ȼ�����ˣ��ͱ���main�������array��������49��ָ��Ӧ�ü����ƶ�
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
        ����һ��ʼд���ˣ��뵱Ȼ�ˣ�һ��ע�⣬����һֱ�ڲ������array
        ѡ������ߵ�����Ϊ��׼֮���ڵ�һ�ֽ�����ʱ�������׼��������������������С�����ƶ�����ν�ġ��м�λ�á���
        ����м�λ����һ������м��λ�ã�����ߵĶ����м�ֵС���ұߵĶ����м�ֵ�󣬵��������Ȼ�������ұ�ͬ��
        ����������������м�ֵ��Ӧ���Ƿŵ���ָ�������ָ���ƶ�֮��ճ�����λ�ã�����һ���м�ֵ����һ��ʼȥ��temp��ֵ��
        ��������̿��Զ���https://www.cnblogs.com/MOBIN/p/4681369.html���ͼ����Ƚ�������
        �ر�ע�⣺��������while loop���棬�𿴻�����2��while loop����ʵ���Ǽ򵥵�2�����Ե�λ�ã���������һЩ���
        ���ܻ�Ƚ��ƣ������ƹ�һ�ξ�����ˣ��´ξ���˼·�ˣ��������array����2�����ڵ���ȵ������������whileѭ���
        ���߿��ܻ�Ե�λ�ã���[6,1,3,7,3]�һ�׼Ԫ��Ϊ6ʱ�������������γ�[1,3,3,6,7],����3�����λ�÷����˸ı䡣
        ��һ����⣺������������������ģ��Ǿ������������ƶ������ﵽ���ֵ; ����Ѿ����ź���ģ�
        ��ô�������ջ����������һ������ң����Ƿ��֣��⻹����������array��Ȼû�б䣬����ÿ��Ԫ�ض���������һ�飬
        ʱ�临�Ӷ�������O(n^2)��
         */
//        temp = arr[_right];
        arr[right] = temp;
//        return temp;//һ��ʼд�������������Ȼ�����ˣ�left��right��Զ����ָ�룬��index�������λ�õ����Ͳ�����
        return right;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(arr.length>0) {
            _quickSort(arr, left, right);
        }
    }
}
