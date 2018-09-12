package thread.con3;

import java.util.concurrent.locks.Lock;

final class Manager {

    private Manager() {}

    public static void transfer(Account from, Account to, int amount) {
        Lock fromLock = from.getLOCK();
        Lock toLock = to.getLOCK();

        try {
            lockBothAccounts(fromLock, toLock);
            if (from.withdraw(amount)) {
                to.add(amount);
            }
        } finally {
            fromLock.unlock();
            toLock.unlock();
        }
    }

    private static void lockBothAccounts(Lock first, Lock second) {
        while(true) {
            boolean firstLocked = first.tryLock();
            boolean secondLocked = second.tryLock();

            if (firstLocked && secondLocked) {
                return;
            }

            if (firstLocked) {
                first.unlock();
            }

            if (secondLocked) {
                second.unlock();
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
