package com.inuker.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {

    private static final String SOLUTION_URL = "https://github.com/dingjikerbo/leetcode/tree/master/Solutions/Java/";
    private static final String SOLUTION_ROOT = "Solutions/java";

    private static String mProName, mProUrl;

    public static void main(String[] args) {
        readProblem();
        System.out.println(String.format("readLine: name = %s, url = %s", mProName, mProUrl));

        createSolution();
        appendLeetcode();
    }

    private static void readProblem() {
        File file = new File("progen.txt");
        try {
            FileReader input = new FileReader(file);
            BufferedReader reader = new BufferedReader(input);
            mProName = reader.readLine();
            mProUrl = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createSolution() {
        File file = new File(SOLUTION_ROOT, String.format("%s.md", mProName));
        if (!file.exists()) {
            try {
                file.createNewFile();

                String line = String.format("## [%s](%s)", mProName, mProUrl);
                FileWriter writer = new FileWriter(file);
                writer.write(line);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void appendLeetcode() {
        File file = new File("Leetcodes.md");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            String url = String.format("%s%s.md", SOLUTION_URL, mProName);
            String line = String.format("\n### [%s](%s)", mProName, url);
            System.out.println(String.format("append to Leetcodes.md: %s", line));
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
