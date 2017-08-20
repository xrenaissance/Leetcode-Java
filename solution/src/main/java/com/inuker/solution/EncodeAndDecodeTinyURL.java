package com.inuker.solution;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by dingjikerbo on 2017/8/20.
 */

public class EncodeAndDecodeTinyURL {

    private static final String SRC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private HashMap<String, String> mMapLong = new HashMap<>();

    private HashMap<String, String> mMapShort = new HashMap<>();

    private static final int SHORT_URL_LEN = 6;

    private Random mRandom = new Random(System.currentTimeMillis());

    public String encode(String longUrl) {
        if (mMapLong.containsKey(longUrl)) {
            return mMapLong.get(longUrl);
        }

        String shortUrl = "";
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < SHORT_URL_LEN; i++) {
                sb.append(SRC.charAt(mRandom.nextInt(SRC.length())));
            }
            shortUrl = sb.toString();
        } while (mMapShort.containsKey(shortUrl));

        mMapLong.put(longUrl, shortUrl);
        mMapShort.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mMapShort.get(shortUrl);
    }
}
