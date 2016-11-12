package com.example;

public class ProGen {

    public static void main(String[] args) {
        File file = new File("ProFile");

        try {
            FileReader input = new FileReader(file);
            BufferedReader reader = new BufferedReader(input);
            String proName = reader.readLine();
        } catch (Exception e) {
        }
    }

}
