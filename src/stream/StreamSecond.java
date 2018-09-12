package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSecond {
    public static void main(String[] args) {

        Long count = Stream.of(1,2,3,4,5)
                .peek(a -> System.out.print(a + " "))
                .count();
        System.out.println("\n" + count);
        //in J9 this doesn't work

        String str = "I should to learn english.";
        boolean has = Stream.of(args).anyMatch(x->x.startsWith("le"));

        //short circuit J9 need see documentation for methods
        //stream may not perform all operations
        // if it is possible to obtain a result without performing part of them

        List<List<String>> lists = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("moo", "koo", "goo")),
                new ArrayList<>(Arrays.asList("Java", "Kotlin", "Groovy")),
                new ArrayList<>(Arrays.asList("Hello", "Good bye"))));
        System.out.println(lists.stream()
            .flatMap(List::stream)
            .peek(a-> System.out.print(a + " "))
            //the number of operations is less, since the result is found
            //but flatMap forces you to execute the sub-stream to the end
            .anyMatch("Java"::equals));
        //flatMap extends the stream with internal elements
        //List.of(..., ..., ...) J9 creating unchanged lists


        Map<Integer, List<String>> mapLists = lists.stream().collect(Collectors.toMap(List::hashCode, a->a));
        List<String> lStrs = mapLists
                .values()
                .stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println(lStrs);

        Map<Integer, List<String>> mapLists1 = stringByLength(lists.get(1));
        System.out.println(mapLists1);







    }

    static Map<Integer, List<String>> stringByLength(List<String> strL){
        return strL.stream().collect(Collectors.groupingBy(String::length));
        //collect value in list if length the same
    }



}
