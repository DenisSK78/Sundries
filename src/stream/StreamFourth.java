package stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamFourth {
    public static void main(String[] args) {
        Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight")
                .collect(minmax(Comparator.comparingInt(String::length),
                        (min, max) -> min + " | " +max))
                .ifPresent(System.out::println);

        Stream.of(23, 43, 4, 6, 34, 3, 43, 99)
                .collect(minmax(Comparator.comparingInt(Integer::intValue),
                        (min, max) -> min + " | " +max))
                .ifPresent(System.out::println);
    }

    static <T, R> Collector<T, ?, Optional<R>> minmax
            (Comparator<? super T> cmp,
             BiFunction<? super T, ? super T, ? extends R> finisher){

        class Acc {
            T min;
            T max;
            boolean present;

            void add(T t){
             if(present){
                 if(cmp.compare(t, min) < 0) min = t;
                 if(cmp.compare(t, max) > 0) max = t;
             }else {
                 min = max = t;
                 present = true;
             }
            }

            Acc combine(Acc other){
                if (!other.present) return this;
                if (!present) return other;
                if (cmp.compare(other.min, min) < 0) min = other.min;
                if (cmp.compare(other.max, max) < 0) max = other.max;
                return this;
            }
        }

        return Collector.of(
                Acc::new,
                Acc::add,
                Acc::combine,
                acc -> acc.present ? Optional.of(finisher.apply(acc.min, acc.max)) : Optional.empty()
        );
    }
}




