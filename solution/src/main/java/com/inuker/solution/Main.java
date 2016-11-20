package com.inuker.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        char[] buf = new char[128];
        int size = new ReadNCharactersGivenRead4II().read(buf, 1);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print(buf[i] + " ");
        }
        System.out.println();
        size = new ReadNCharactersGivenRead4II().read(buf, 2);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print(buf[i] + " ");
        }

    }


}
