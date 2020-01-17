package com.lmk.headsort;

import java.util.Arrays;

public class TestHeadSort {
    public static void main(String[] args) {
        HeadSort headSort = new HeadSort();
        int arr[] = new int[]{7,2,4,5,6,2};
        headSort.sortSwapHead(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
