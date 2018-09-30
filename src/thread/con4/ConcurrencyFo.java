package thread.con4;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrencyFo {
    public static void main(String[] args) {
        final int THREADS = Runtime.getRuntime().availableProcessors();
        System.out.println(THREADS);

        CountDownLatch latch = new CountDownLatch(1);

        Runnable r = () -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In thread " + Thread.currentThread());
        };

        List<Thread> threads = Stream.generate(() -> new Thread(r))
                .limit(THREADS)
                .peek(Thread::start)
                .peek(System.out::println)
                .collect(Collectors.toList());

        latch.countDown();

        System.out.println();

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
