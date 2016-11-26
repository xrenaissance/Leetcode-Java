package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int len = new LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        System.out.println(len);
    }
}
