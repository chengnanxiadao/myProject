package com.myalgorithmproject.day20200401;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution20220401 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int a : arr) {
            counter.put(a, counter.getOrDefault(a, 0) + 1);
        }
        int removed = 0;
        // 1.要排序,因为下面是*2的单向匹配
        Arrays.sort(arr);
        for (int a : arr) {
            // 都匹配上了，map为空，代表成功
            if (removed >= arr.length) {
                return true;
            }
            int d = a * 2;
            final Integer dv = counter.get(d);
            final Integer av = counter.get(a);
            if (dv == null || av == null || dv <= 0 || av <= 0) {
                continue;
            }
            counter.put(d, dv - 1);
            removed++;
            counter.put(a, av - 1);
            if (a != 0) {
                removed++;
            }
        }
        return removed >= arr.length;
    }
}
