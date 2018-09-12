package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IoT {


    private static final String VOWELS = "йуеыаоэяиюё";
    private static final File DIRECTORY = new File("src" + File.separator + "io");

    public static void main(String[] args) throws IOException {
        File file = new File(DIRECTORY, "task.txt");
        boolean ok = file.createNewFile();
        System.out.println(ok);

        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
            while (scanner.hasNext()){
                String world = scanner.next();
//                if (world.matches("о.+")) {
//                    System.out.println(world);
//                }
                if (startsWithVowel(world)){
                    System.out.println(world);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static boolean startsWithVowel(String world){
        return VOWELS.indexOf(world.toLowerCase().charAt(0)) > -1;
    }
}
