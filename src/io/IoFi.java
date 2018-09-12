package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class IoFi {
    //replace
    private static final File DIRECTORY = new File("src" + File.separator + "io");

    public static void main(String[] args) {

        File file1 = new File(DIRECTORY, "public.txt");
        File file2 = new File(DIRECTORY, "reversed.txt");

        try (Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(file1)));
             PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file2)))){
            while (sc.hasNextLine()){
                String str = new StringBuilder(sc.nextLine()).reverse().toString();
                pw.write(str + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
