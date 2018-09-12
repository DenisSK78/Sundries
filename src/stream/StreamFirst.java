package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamFirst {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("12345", "123", "1234", "12", "1", "123", "1234", "12", "1", "123", "1234", "12", "1", "123", "1234", "12", "1");

        myList.stream()
                .filter(s -> s.length() > 2)
                .map(s -> s + s)
//                .map(s -> Integer.valueOf(s))
                .map(Integer::valueOf)//the same as above
                .map(integer -> integer * 2)
                .forEach(System.out::println);

        Integer result1 = myList.stream()
                .filter(s -> s.length() > 2)
                .map(s -> s + s)
//                .map(s -> Integer.valueOf(s))
                .map(Integer::valueOf)
                //the same as above
                .map(integer -> integer * 2)
                .reduce(0, (a, b)-> a + b);
        System.out.println("1: " + result1);

        Map<Integer, String> result2 = myList.stream()
                .filter(s -> s.length() > 2)
                .map(s -> s + s)
                .distinct()
                //method skips something that does not repeat
                .collect(Collectors.toMap(String::length, s -> s));
        System.out.println("2: " + result2);

        String result3 = myList.stream()
                .filter(s -> s.length() > 2)
                .map(s -> s + s)
                .distinct()
                //method skips something that does not repeat
                .sorted()
                //method can hav parameter comparator
                .collect(Collectors.joining(" : "));

        System.out.println("3: " + result3);

        Integer result4 = Math.toIntExact(myList.stream()
                .filter(s -> s.length() > 2)
                .map(s -> s + s)
                .mapToInt(Integer::valueOf)
                //stream Integers has more methods for Integer
                // (we have different types stream)
                .sum());
        System.out.println("4: " + result4);

        List<StringBuilder> result5 = myList.stream()
                .filter(s -> s.length() >= 2)
                .map(s -> s + s)
                .map(StringBuilder::new)
                //stream Integers has more methods for Integer
                // (we have different types stream)
                .collect(Collectors.toList());
        System.out.println("5: " + result5);

        long start = System.currentTimeMillis();
        myList
                .parallelStream()
                //do stream in different threads
                .forEach(StreamFirst::delay);
        System.out.println("Time: "+(System.currentTimeMillis() - start));
    }

    private static String delay(String s){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print(s+" ");
        return s;
    }
}
