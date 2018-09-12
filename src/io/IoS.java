package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IoS {

    private static final String DIR_SRC = "src";
    private static final String DIR_RESOURCES = "resources";

    public static void main(String[] args) throws IOException {

        File resourcesDirectory = new File(DIR_SRC, DIR_RESOURCES);
        boolean dirCreated = resourcesDirectory.mkdir();
        System.out.println(dirCreated);

        File file = new File(resourcesDirectory,  "write.txt");
        boolean b = file.createNewFile();
        System.out.println(b);

        try (BufferedWriter bW = new BufferedWriter(new FileWriter(file, true))){
            bW.write("ok");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
