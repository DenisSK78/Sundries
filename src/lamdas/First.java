package lamdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class First {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList("12345", "123", "1234", "12", "1");

//        Collections.sort(myList, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return Integer.compare(s1.length(), s2.length());
//            }
//        });
//
//        Collections.sort(myList, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
//
//        Collections.sort(myList, Comparator.comparingInt(String::length));

        myList.sort(Comparator.comparingInt(String::length));

        for (String str : myList){
            System.out.print(str+" ");
        }
    }
}
