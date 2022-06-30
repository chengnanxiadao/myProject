package com.myalgorithmproject.day202206.day20220630;


import java.util.ArrayList;
import java.util.List;

class Solution20220630 {
    static int MOD = (int)1e9+7;
    static List<Integer> list = new ArrayList<>();
    static{
        for (int i = 2;i<100;i++){
            boolean ok = true;
            for(int j = 2;j<i;j++){
                if(i%j==0) ok=false;
            }
            if(ok) list.add(i);
        }
    }
    public int numPrimeArrangements(int n) {
        int l = 0;int r = list.size()-1;
        while(l<r){
            int mid = l + r +1 >>1;
            if(list.get(mid)<=n) l = mid;
            else r = mid-1;
        }
        int a = r +1;
        int b = n-a;
        long ans = 1;
        for(int i = a;i>1;i--) ans = ans*i % MOD;
        for(int i = b;i>1;i--) ans = ans*i % MOD;
        return (int)ans;


    }
}
