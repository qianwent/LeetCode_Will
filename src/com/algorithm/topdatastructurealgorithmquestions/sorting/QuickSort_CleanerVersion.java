package com.algorithm.topdatastructurealgorithmquestions.sorting;

/**
 * Created by Wentao Qian on 12/4/2017.
 * original website: https://www.cnblogs.com/MOBIN/p/4681369.html
 */
public class QuickSort_CleanerVersion {
    public static void quickSort(int arr[],int _left,int _right){
        int left = _left;//ע����������ָ�붼���������ˣ���Ϊ�ݹ��ʱ��Ҫ�õ�
        int right = _right;
        int temp = 0;
        if(left <= right){   //�������Ԫ�����������������
            temp = arr[left];  //������ĵ�һ��Ԫ����Ϊ��׼Ԫ��
            while(left != right){   //���������߽���ɨ�裬ֱ��left = right

                while(right > left && arr[right] >= temp)
                    right --;        //��������ɨ�裬�ҵ���һ���Ȼ�׼Ԫ��С��Ԫ��
                arr[left] = arr[right];  //�ҵ�����Ԫ��arr[right]����arr[left]����

                while(left < right && arr[left] <= temp)
                    left ++;         //��������ɨ�裬�ҵ���һ���Ȼ�׼Ԫ�ش��Ԫ��
                arr[right] = arr[left];  //�ҵ�����Ԫ��arr[left]����arr[right]����

            }
            arr[right] = temp;    //��׼Ԫ�ع�λ //TODO:Ŀǰ��������������һ����right==left
            //TODO����Ȼ�Ǽ������������Ѿ����ź���ģ�����ָ���һֱ�ݼ�ֱ��==0�������Ҫ�����һ��
            //���ݹ��ɷ������Եó����ۣ�����right==left
            quickSort(arr,_left,left-1);  //�Ի�׼Ԫ����ߵ�Ԫ�ؽ��еݹ�����
            quickSort(arr, right+1,_right);  //�Ի�׼Ԫ���ұߵĽ��еݹ�����
        }
    }
    public static void main(String[] args) {
        int array[] = {10,5,3,1,4,7,2,8};
        System.out.println("����֮ǰ��");
        for(int element : array){
            System.out.print(element+" ");
        }

        quickSort(array,0,array.length-1);

        System.out.println("\n����֮��");
        for(int element : array){
            System.out.print(element+" ");
        }

        System.out.println();

        int arr[] = {1,2,3};
        quickSort(arr, 0, arr.length-1);
        for(int i: arr) {
            System.out.print(i + " ");
        }

    }
}
