/*
package com.example.demo.persistence;

import java.io.*;
import java.util.ArrayList;

public class Util {
    public static ArrayList<String> readFile(String path) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            list.add(line);
        }
        bufferedReader.close();
        fileReader.close();
        return list;
    }

    public static void saveFile(String path, String content, Boolean b) throws IOException{
        FileWriter writer = new FileWriter(path, b);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(content);
        bufferedWriter.close();
        writer.close();
    }

}
*/