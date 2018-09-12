package lamdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Third {
    public static void main(String[] args) {

        Runnable r = (args.length > 0) ?
                () -> System.out.println(args[0]) :
                () -> System.out.println("Nothing!");
        r.run();

        IntSupplier x = () -> 5;
        //java.util.function has a lot of factional interfaces

        Integer a = 3;
        Integer b = 5;

        IntBinaryOperator sum = Integer::sum;
        Integer c = sum.applyAsInt(a,b);
        //sum can use as function for event
        System.out.println(sum.applyAsInt(3,5));

        Function<String, String> trimmer = String::trim;
        String str = " Бла-бла-бла ";
        String strRed = trimmer.apply(str);
        System.out.println("_" + strRed + "_");

        Predicate<String> predicate = "Vanya"::equals;
        List<String> strAr = Arrays.asList("Vanya", "Gena", "Olya", "Vanya");
        strAr.stream().filter(predicate).forEach(System.out::println);
        System.out.println(predicate.test("Serg") + " : " + predicate.test("Vanya"));

        Consumer<Object> consumer = System.out::println;
        consumer.accept("Milk");

        Supplier<List<String>> supplier = ArrayList::new;
        //supplier uses constructor of class ArrayList without args
        List<String> arrayList = supplier.get();
        arrayList.addAll(Arrays.asList("GGG", "MMM", "UUU"));
        arrayList.forEach(Third::accept);

        System.out.println();

        IntFunction<String[]> arrFactory = String[]::new;
        String [] arr = arrFactory.apply(3);

    }

    private static void accept(String a) {
        System.out.print(a + " ");
    }
}
