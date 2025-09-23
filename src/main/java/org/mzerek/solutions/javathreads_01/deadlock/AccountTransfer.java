package main.java.org.mzerek.solutions.javathreads_01.deadlock;

import java.util.Random;

//https://javaprzyklady.blogspot.com/2014/07/wielowatkowosc-zywotnosc.html
public class AccountTransfer {

    private static class Account {
        private String number;
        private Integer balance;
        public Account(String number, Integer balance) {
            this.number = number;
            this.balance = balance;
        }
        public void setNewBalance(Integer amount) {
            balance += amount;
        }
        public String getNumber() {
            return number;
        }
        public Integer getBalance() {
            return balance;
        }
    }
    private static class TransferTask implements Runnable {
        private Account from;
        private Account to;
        public TransferTask(Account from, Account to) {
            this.from = from;
            this.to = to;
        }

        //deadlock transfer
        public void deadLockTransfer(Account from, Account to, Integer amount) {
            synchronized (from) {
                System.out.println("From: " + from.getNumber());
                synchronized (to) {
                    System.out.println(" To: " + to.getNumber());
                    if (from.getBalance() > amount) {
                        from.setNewBalance(-1 * amount);
                        to.setNewBalance(amount);
                    }
                }
            }
        }

        //deadlock transfer
        public void noDeadlLockTransfer(Account from, Account to, Integer amount) {
            int compareTo = from.getNumber().compareTo(to.getNumber());
            if (compareTo > 0) {
                synchronized (from) {
                    synchronized (to) {
                        trasferInternal(from, to, amount);
                    }
                }
            } else {
                synchronized (to) {
                    synchronized (from) {
                        trasferInternal(from, to, amount);
                    }
                }
            }
        }
        private void trasferInternal(Account from, Account to, Integer amount) {
            if (from.getBalance() > amount) {
                from.setNewBalance(-1 * amount);
                to.setNewBalance(amount);
            }
        }

        @Override
        public void run() {
            Random r = new Random();
            while (true) {
                int nextInt = r.nextInt(100);
                System.out.println("From: " + from.getNumber() + " To: " + to.getNumber() + " Transfering " + nextInt);
                noDeadlLockTransfer(from, to, nextInt);
            }
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account("1", 10000);
        Account account2 = new Account("2", 20000);
        new Thread(new TransferTask(account1, account2)).start();
        new Thread(new TransferTask(account2, account1)).start();
    }
}
