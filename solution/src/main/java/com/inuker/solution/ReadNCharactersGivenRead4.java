package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/20.
 */

public abstract class ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        for (int i = 0; i < n; ) {
            int k = read4(tmp);
            // 这里i<n很容易忽略
            for (int j = 0; i < n && j < k; ) {
                buf[i++] = tmp[j++];
            }
            if (k < 4) {
                return i;
            }
        }
        return n;
    }

    abstract int read4(char[] buf);
}
