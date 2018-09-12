package thread.con3;

public class Bank {

    public static void main(String[] args) {

        Account firstAcc = new Account();
        Account secondAcc = new Account();

        Thread thread1 = new Thread(new Contribution(firstAcc, secondAcc));
        Thread thread2 = new Thread(new Contribution(secondAcc, firstAcc));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("balance f: " + firstAcc.balance());
        System.out.println("balance s: " + secondAcc.balance());

    }

    private static class Contribution implements Runnable{

        private final Account firstAcc;
        private final Account secondAcc;

        private Contribution(Account firstAcc, Account secondAcc) {
            this.firstAcc = firstAcc;
            this.secondAcc = secondAcc;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                Manager.transfer(firstAcc, secondAcc, 100);
            }
        }
    }
}
