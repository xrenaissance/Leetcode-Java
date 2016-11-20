package com.inuker.solution;

/**
 * Created by dingjikerbo on 16/11/20.
 */

public class ReadNCharactersGivenRead4II {

    private char[] temp = new char[4];
    private int index, size;

    public int read(char[] buf, int n) {
        for (int i = 0; i < n; ) {
            // 先读之前没读完的
            while (i < n && index < size) {
                buf[i++] = temp[index++];
            }

            // 如果读够了先返回，否则重置
            if (i >= n) {
                return n;
            } else {
                index = 0;
                size = 0;
            }

            if (i < n) {
                if ((size = read4(temp)) == 0) {
                    return i;
                }
            }
        }
        return n;
    }

    int time = 0;
    int read4(char[] buf) {
        if (time == 0) {
            buf[0] = 'a';
            buf[1] = 'b';
            time = 1;
            return 1;
        } else {
            return 0;
        }

    }
}
