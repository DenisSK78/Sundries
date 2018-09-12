package iterable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class IteratorMain {
    public static void main(String[] args) {
        Set<Integer> objects = new HashSet<>();
        objects.add(7);
        objects.add(3);
        objects.add(6);
        objects.add(9);
        objects.add(4);
        objects.add(2);

        printAll(nCopies(objects, 1));

        objects.iterator().forEachRemaining(a -> {
            if (a.equals(9)) {
                System.out.println("-> 9");
            }
        });


    }

    private static <T> Iterable<T> nCopies(T value, int count){
        if (count < 0) {
            throw new IllegalArgumentException("Negative count: " + count);
        }

        return () -> new Iterator<T>() {
            int rest = count;
            @Override
            public boolean hasNext() {
                return rest > 0;
            }
            @Override
            public T next() {
                if(rest == 0) throw new NoSuchElementException();
                rest--;
                return value;
            }
        };
    }

    private static void printAll(Iterable<?> iterable){
        for (Object anIterable : iterable) {
            System.out.println(anIterable);
        }
    }

    //    static <T> Iterable<T> nCopies(T value, int count){
//        if (count < 0) {
//            throw new IllegalArgumentException("Negative count: " + count);
//        }
//        return new Iterable<T>() {
//            @Override
//            public Iterator<T> iterator() {
//                return new Iterator<T>() {
//                    int rest = count;
//                    @Override
//                    public boolean hasNext() {
//                        return rest > 0;
//                    }
//                    @Override
//                    public T next() {
//                        if(rest == 0) throw new NoSuchElementException();
//                        rest--;
//                        return value;
//                    }
//                };
//            }
//        };
//    }
}
