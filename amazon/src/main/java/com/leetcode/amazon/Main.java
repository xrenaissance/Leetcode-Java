package com.leetcode.amazon;

/**
 * Created by liwentian on 2017/10/16.
 */

public class Main {

    public static void main(String[] args) {
        EncodeAndDecodeTinyUrl s = new EncodeAndDecodeTinyUrl();
        String shortUrl = s.encode("http://baidu.com");
        System.out.println(shortUrl);

        System.out.println(s.decode(shortUrl));
    }
}
