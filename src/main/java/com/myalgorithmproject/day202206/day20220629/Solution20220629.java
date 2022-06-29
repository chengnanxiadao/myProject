package com.myalgorithmproject.day202206.day20220629;

import java.util.HashMap;
import java.util.Map;

public class Solution20220629 {
    Map<String,String> map = new HashMap<>();
    static final String INDEX = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String TINYURL_PREFIX = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] arr = new char[6];
        for(int i = 0;i<6;i++){
            arr[i] = INDEX.charAt((int)(Math.random()*62));
        }
        String shortUrl = TINYURL_PREFIX + new String(arr);
        if(!map.containsKey(shortUrl)){
            map.put(shortUrl,longUrl);
        }
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

