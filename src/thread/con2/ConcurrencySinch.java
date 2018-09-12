package thread.con2;

public class ConcurrencySinch {


        private static int count = 0;
        private static int count2 = 0;
        private static final Object LOOK = new Object();

        private synchronized static void add(){
            if (count==500){
                System.out.println("11:" + count);
                System.out.println("12:" + count2);
            }
            count++;
        }

        private static void addS(){
            synchronized (LOOK){
                if (count2==500){
                    System.out.println("21:" + count);
                    System.out.println("22:" + count2);
                }
                count2++;
            }
        }

        public static void main(String[] args) throws InterruptedException {

            Thread thread1 = new Thread(()-> {
                for (int i = 0; i < 1000; i++) {
                    add();
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    add();
                }
            });

            Thread thread3 = new Thread(()-> {
                for (int i = 0; i < 1000; i++) {
                    addS();
                }
            });

            Thread thread4 = new Thread(()-> {
                for (int i = 0; i < 1000; i++) {
                    addS();
                }
            });

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            System.out.println(count);
            System.out.println(count2);
    }
}
