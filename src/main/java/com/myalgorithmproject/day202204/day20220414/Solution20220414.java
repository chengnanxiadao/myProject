package com.myalgorithmproject.day202204.day20220414;

public class Solution20220414 {
    public int maximumWealth(int[][] accounts) {
        int sum = 0;
        for(int[] account: accounts){
            int cur_sum = 0;
            for(int money: account){
                cur_sum += money;
            }
            if(cur_sum > sum){
                sum = cur_sum;
            }
        }
        return sum;
    }
}
