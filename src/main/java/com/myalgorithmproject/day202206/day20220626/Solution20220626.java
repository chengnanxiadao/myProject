package com.myalgorithmproject.day202206.day20220626;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
public class Solution20220626 {
    List<int[]> list = new ArrayList<>();
    int[] sum = new int[100010];
    int sz;
    Random random = new Random();
    public Solution20220626(int n, int[] bs) {
        // Write your solution here
        Arrays.sort(bs);
        int m = bs.length;
        if (m == 0) {
            list.add(new int[]{0, n - 1});
        } else {
            if (bs[0] != 0) list.add(new int[]{0, bs[0] - 1});
            for (int i = 1; i < m; i++) {
                if (bs[i - 1] == bs[i] - 1) continue;
                list.add(new int[]{bs[i - 1] + 1, bs[i] - 1});
            }
            if (bs[m - 1] != n - 1) list.add(new int[]{bs[m - 1] + 1, n - 1});
        }
        sz = list.size();
        for (int i = 1; i <= sz; i++) {
            int[] info = list.get(i - 1);
            sum[i] = sum[i - 1] + info[1] - info[0] + 1;
        }
    }
    public int pick() {
        // Write your code here
        int val = random.nextInt(sum[sz]) + 1;
        int l = 1, r = sz;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= val) r = mid;
            else l = mid + 1;
        }
        int[] info = list.get(r - 1);
        int a = info[0], b = info[1], end = sum[r];
        return b - (end - val);
    }

}


