package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class IoF {

    private static final String DIR_SRC = "src";
    private static final String DIR_RESOURCES = "resources";

    public static void main(String[] args) throws IOException {

//        File file = new File(DIR_RESOURCES + File.separator + "poem.txt");
        //use File.separator for ...

        File resourcesDirectory = new File(DIR_SRC, DIR_RESOURCES);
        boolean dirCreated = resourcesDirectory.mkdir();
        System.out.println(dirCreated);

        File file = new File(resourcesDirectory,  "poem.txt");
        boolean b = file.createNewFile();
        System.out.println(b);

        System.out.println(resourcesDirectory.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.delete());
//        System.out.println(resourcesDirectory.delete());

        System.out.println(file.exists());

        FileInputStream fIS = new FileInputStream(file);
//        byte [] bytes = new byte[300];
//        fIS.read(bytes);
//        System.out.println(Arrays.toString(bytes));
//-----------------------------------------
//        BufferedInputStream bIS = new BufferedInputStream(fIS);
//        Scanner scanner = new Scanner(bIS);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            System.out.println(line);
//        }

//--------------------------------------
        //decorator below
        Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)));
        scanner.useDelimiter("\\,|\\s+\\|\\.");//
        while (scanner.hasNext()) {
            String line = scanner.next();//
            System.out.println(line);
        }
        scanner.close();
    }
}
