package engl;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class EnM {

    public static void main(String[] args) {

        int firstPart = 30;
        int sum = 2;
        Integer [] second = new Integer[]{82,83,84,85,86,87,88,89,90,91};

        getRandomNumbers(
                Stream.concat(Arrays.stream(Stream.iterate(1, x->x+1).limit(firstPart).toArray(Integer[]::new)),
                        Arrays.stream(second))
                .toArray(Integer[]::new), sum);
    }

    private static void getRandomNumbers(Integer[] integers, Integer sum){
        Stream.iterate(0, x -> x+1).limit(sum)
            .map(a -> a = integers[new Random().nextInt(integers.length)])
            .forEach(System.out::println);
    }
}
