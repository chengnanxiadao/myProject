package com.myalgorithmproject.day202206.day20220628;

import java.util.Arrays;

public class Solution20220628 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = (n + 1) / 2;
        int[] copy = new int[n];
        //数组拷贝
        System.arraycopy(nums, 0, copy, 0, n);
        for (int i = 0; mid - 1 - i >= 0; i++) {
            nums[2 * i] = copy[mid - 1 - i];
        }
        for (int i = 0; n - 1 - i >= mid; i++) {
            nums[2 * i + 1] = copy[n - 1 - i];
        }

    }

}
