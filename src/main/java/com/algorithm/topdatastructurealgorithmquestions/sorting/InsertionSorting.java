package com.algorithm.topdatastructurealgorithmquestions.sorting;

/**
 * Created by Wentao Qian on 12/6/2017.
 */
public class InsertionSorting {
    /*
    ԭ��ܼ򵥣�������Ҫд����ȷʵ����һ������ȥ���
    ���ȵ�һ��Ԫ�ز�����Ȼ��ÿһ�δ�ѭ�����ǰ������i��Ԫ�ز��뵽֮ǰ�Ѿ��ź���Ķ��鵱��
    ��ô��ʹ�����Ԫ�ز���֮��������Ȼ��ȷ���Ǿ�Ҫ�Ӻ���ǰ�ٱ���һ��
    �������˼·��ʣ�µľ����жϺ�arr[j+1] = arr[j];arr[j+1] = temp;�������߼���
    �������Ϊʲô����arr[j+1] = temp;��Ϊ֮ǰѭ�����arr[j+1] = arr[j];һֱ���ڸ�temp���Ƚ�
    ���ʱ����е��������ˣ���������һ��arr[j+1] = arr[j]��ִ�У���ζ��temp��λ�ñ�arr[j]ȡ��
    ����ʱ��ԭ��arr[j]��λ����Ȼ���䱾����������ɿճ����ˣ�temp����Ҫ������ȱ�������ȱ�ֲ��������
    ��Ϊǰ������ֻ�Ҫ��temp�ȣ����temp����С��ǰ��������������ˣ�ֱ����ѭ�����������㣬
    ���ʱ��tempλ������������Ӧ����j���������j--����Ҫ��j��ԭ�����Ա����arr[j+1] = temp;
    TODO����������ԭ���Ϻܺ���⣬����д�������ǵ�һ�Σ��ü�ס
    ʱ�临�Ӷ�������O(n^2)
     */
    public static void insertionSorting(int[] arr) {
        int temp, i, j, n=arr.length;
        //�������ѭ������bubble sortһ��������ѭ��n-1��
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
