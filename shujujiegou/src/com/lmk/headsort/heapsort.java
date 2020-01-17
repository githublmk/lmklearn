package com.lmk.headsort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class heapsort {

    /**
     *                     9
     *                   8   6
     *                 7  0 2  5
     *                2 3
     *
     * @param args
     */

    public static void main(String[] args) {

        heapsort h = new heapsort();
        int[] sortarrray = h.waitSortArray;

//        for(int i =sortarrray.length-1;i>=0;i--){
//            h.heapSort(sortarrray,i);
//            System.out.println(Arrays.toString(sortarrray));
//        }

        for (int i = 0; i < sortarrray.length; i++) {

            //每次建堆就可以排除一个元素了
            h.heapSort(sortarrray, sortarrray.length - i);

            //交换
            int temp = sortarrray[0];
            sortarrray[0] = sortarrray[(sortarrray.length - 1) - i];
            sortarrray[(sortarrray.length - 1) - i] = temp;

        }
        System.out.println(Arrays.toString(sortarrray));


    }


    public void heapSort(int arr[],int size){
//        int start = (arr.length-1)/2;
//        for(int i = start;i>0;i--){
//            maxHeap(arr,i,arr.length);
//        }
//        int temp =arr[0];
//        arr[0]=arr[size];

        for (int i = size - 1; i >= 0; i--) {
            maxHeap(arr, (i-1)/2, size);
        }

    }
    int[] waitSortArray = new int[]{7,2,4,5,6,2};
    /**
     *                              7
     *                             2   6
     *                           3  0  2  5
     *                         8 9
     */

    /**
     *
     * @param arr 数组
     * @param currentRootIndex 当前节点父节点的位置
     * @param size 节点总数
     */
    public void maxHeap(int arr[],int currentRootIndex,int size){

        if(currentRootIndex<size){
            int leftNode = 2*currentRootIndex+1;
            int rightNode = 2*currentRootIndex+2;

            int max = currentRootIndex;
            if(leftNode<size&&arr[max]<arr[leftNode]){
                max= leftNode;
            }
            if(rightNode<size&&arr[max]<arr[rightNode]){
                max = rightNode;
            }

            if(max !=currentRootIndex){
                int temp = arr[max];
                arr[max] = arr[currentRootIndex];
                arr[currentRootIndex]=temp;
                maxHeap(arr,max,size);
            }

        }
    }
}
