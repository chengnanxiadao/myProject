package com.myalgorithmproject.day202204.day20220424;

class Solution20220424 {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int pre = -1;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(pre==-1){
                    pre = i;
                }else{
                    max = Math.max(i-pre,max);
                    pre = i;
                }
            }
        }
        return max;

    }
}
