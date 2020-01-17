package com.lmk.headsort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeadSort {
    /**
     * 排一次子堆
     * @param arr 数组
     * @param size 节点数
     * @param currentparents 父节点索引
     */
    public void maxHead(int[] arr,int size,int currentparents){

        if(currentparents<size){


            //左节点索引
            int left = 2*currentparents+1;
            //右节点索引
            int right =2*currentparents+2;
            //假设最大数的索引为当前索引
            int max = currentparents;
            //如果左节点数大于最大节点，最大值为左节点
            if(left<size&&arr[left]>arr[max]){
                max =  left;
            }

            //如果右节点数大于最大值，最大值为右节点
            if(right<size&&arr[right]>arr[max]){
                max = right;
            }
            //最大值不等于当前节点，交换位置
            if(max!=currentparents){
                int temp = arr[max];
                arr[max] = arr [currentparents];
                arr[currentparents] = temp;
                //继续排序
                maxHead(arr,size,max);
            }
        }

    }


    /**
     *
     * @param arr 数组
     * @param size 排序的长度
     */
    public void sortHead(int[] arr,int size){


        for(int i =size-1;i>=0;i--){
            //父节点位置
            int start  = (i-1)/2;
            maxHead(arr,size,start);
        }
    }

    /**
     *
     * @param arr 待排序数组
     */
    public void  sortSwapHead(int[] arr){

        for(int i = 0;i<arr.length;i++){
            System.out.println("length:"+(arr.length-i));
            sortHead(arr,arr.length-i);
            //交换位置
            System.out.println(Arrays.toString(arr));
            int temp = arr[0];
            arr[0] = arr[arr.length-i-1] ;
            arr[arr.length-i-1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
