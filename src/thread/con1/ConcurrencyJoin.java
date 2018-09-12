package thread.con1;

public class ConcurrencyJoin {

    private static Integer count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 1000; i++) {
//                System.out.println("first : "+ count);
                count++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//                System.out.println("second: "+ count);
                count++;
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        //The current thread (main) will wait finish thread.join()
        thread2.join();
        System.out.println(count);

    }
}
