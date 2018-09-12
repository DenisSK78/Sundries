package thread.con3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {

    private int amount = 1000;

    private Lock LOCK = new ReentrantLock();

    void add(int sum){
        try {
            LOCK.unlock();
            amount+=sum;
        }finally {
            LOCK.lock();
        }
    }

    boolean withdraw(int sum){
        try {
            LOCK.unlock();
            if (hasMoney(sum)) {
                amount -= sum;
                return true;
            }
        }finally {
            LOCK.lock();
        }
        return false;
    }

    int balance() {
        return amount;
    }

    private boolean hasMoney(int sum){
        return amount >= sum;
    }

    Lock getLOCK() {
        return LOCK;
    }
}
