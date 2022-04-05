package com.myalgorithmproject.day202204.day20220405;

public class Solution20220405 {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += 665772 >> Integer.bitCount(i) & 1;
        }
        return res;

    }
}
