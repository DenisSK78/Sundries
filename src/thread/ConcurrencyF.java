package thread;

import static java.lang.Thread.sleep;

public class ConcurrencyF {
    public static void main(String[] args) {

        PrintTread pth = new PrintTread();
        pth.setName("First!");
        pth.start();
        System.out.println("Main first.");
        Thread thread = new Thread(new PrintRunnable());
        System.out.println("Main second.");
        thread.start();
        System.out.println("Main third.");
        System.out.println("f");
        System.out.println("s");
    }

    private static class PrintTread extends Thread{
        @Override
        public void run() {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread is running.");
        }
    }

    private static class PrintRunnable implements Runnable{
        @Override
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread runnable is running.");
        }
    }


}

