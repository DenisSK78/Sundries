package mapl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapL {
    public static void main(String[] args) {
        Map<Integer, String> mapka = new HashMap<>();

        mapka.put(1,"oneFirst");
        mapka.put(2, "two");

        System.out.println("--1--");
        String a = mapka.put(1, "oneSecond");
        System.out.println(a);
        //put can get old value

        System.out.println("--2--");
        String b = mapka.getOrDefault(3, "Doesn't have this key");
        System.out.println(b);
        mapka.put(4, null);
        String c = mapka.getOrDefault(4, "Smth");
        System.out.println(c);

        System.out.println("--3--");
        String d = mapka.putIfAbsent(2, "twoSecond");
        //if value not null, method this method return old value and doesn't rewrite value
        System.out.print(d + " - ");
        System.out.println(mapka.get(2));
        String e = mapka.putIfAbsent(4, "notNull");
        System.out.print(e+ " - ");
        System.out.println(mapka.get(4));
        //if null method rewrite value

        System.out.println("--4--");
        mapka.put(5, "five");
        mapka.remove(5, "fiv");
        //remove if values equals
        System.out.print(mapka.get(5) + " - ");
        mapka.remove(5, "five");
        System.out.println(mapka.get(5));

        System.out.println("--5--");
        mapka.put(5, "five");
        mapka.replace(5, "five", "fiveNew");
        System.out.println(mapka.get(5));
        //replace if value equals

        System.out.println("--6--");
        iterateMap(mapka);

        System.out.println("--7--");
        iterateValues(mapka);

        System.out.println("--8--");
        mapka.values()
//                .stream()
                .forEach(System.out::println);
        //it's the same what in 7

        System.out.println("--9--");
        iterateMapJ8(mapka);

        removeIfJ8(mapka);

    }

    private static void iterateMap(Map<Integer, String> mapka){
        for (Map.Entry<Integer, String> entry : mapka.entrySet()){
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + " " + "Value: " + value);
        }
    }

    private static void iterateValues(Map<Integer, String> mapka) {
        for (String value : mapka.values()){
            System.out.println(value);
        }
    }

    private static void iterateMapJ8(Map<Integer, String> mapka){
        mapka.forEach((key, value) -> System.out.println("Key: " + key + " " + "Value: " + value));
    }

    private static void removeIfJ8(Map<Integer, String> mapka) {
//        mapka.entrySet().removeIf(value ->
//            value.getValue().equals("bla-bla-bla") ||
//            value.getValue().equals("bla-bla"));

//        mapka.values().removeIf(value ->
//                value.equals("bla-bla-bla") ||
//                value.equals("bla-bla"));

        List<String> BAD_VALUES = Arrays.asList("bla-bla-bla", "bla-bla");
        mapka.values().removeAll(BAD_VALUES);
    }
}


