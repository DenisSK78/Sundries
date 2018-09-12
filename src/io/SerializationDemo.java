package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

    private static final File DIRECTORY = new File("src" + File.separator + "io");

    public static void main(String[] args) {
        Person person = new Person("Chuck","Norris", 10);
        System.out.println(person);
        File file = new File(DIRECTORY, "person.txt");

        try (ObjectOutputStream oS = new ObjectOutputStream(new FileOutputStream(file))){
            oS.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(file))){
            Person fromFile = (Person) oIS.readObject();
            System.out.println(fromFile);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
