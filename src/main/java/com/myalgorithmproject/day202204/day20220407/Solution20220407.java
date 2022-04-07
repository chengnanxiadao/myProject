package com.myalgorithmproject.day202204.day20220407;

public class Solution20220407 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
