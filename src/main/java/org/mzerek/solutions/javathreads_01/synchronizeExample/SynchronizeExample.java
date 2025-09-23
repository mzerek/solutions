package main.java.org.mzerek.solutions.javathreads_01.synchronizeExample;

//https://czub.info/2016/java-8-wielowatkowosc-cz1-wstep-theread-synchronizacja/
public class SynchronizeExample {

    abstract class Message {
        public abstract void addMessage(String message);

        void print(String message) {
            System.out.print('[');
            System.out.print(Thread.currentThread().getName());
            System.out.print(']');
            System.out.print(message);
            System.out.println();
            System.out.flush();
        }
    }

    private class NonSynchronisedMessage extends Message {
        @Override
        public void addMessage(String message) {
            print(message);
        }
    }

    private class SynchronisedMethodMessage extends Message {
        @Override
        public synchronized void addMessage(String message) {
            print(message);
        }
    }

    private class SynchronizedBlockMessage extends Message {

        @Override
        public void addMessage(String message) {
            synchronized (this) {
                print(message);
            }
        }
    }

    private class Worker extends Thread {
        private String text;
        private Message message;

        public Worker(String name, String text, Message message) {
            super(name);
            this.text = text;
            this.message = message;
        }

        @Override
        public void run(){
            message.addMessage(text);
        }
    }

    public static void main(String[] args){

        SynchronizeExample synchronizeExample = new SynchronizeExample();
        synchronizeExample.test();
    }

    private void test() {
        System.out.println("Start non synchronized methods");

        Worker worker1 = new Worker("NonSync1", "Hello", new NonSynchronisedMessage());
        Worker worker2 = new Worker("NonSync2", "World", new NonSynchronisedMessage());
        Worker worker3 = new Worker("NonSync3", "!!!", new NonSynchronisedMessage());

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Start synchronized methods");

        Worker syncWorker1 = new Worker("SyncMethod1", "Hello", new SynchronisedMethodMessage());
        Worker syncWorker2 = new Worker("SyncMethod2", "World", new SynchronisedMethodMessage());
        Worker syncWorker3 = new Worker("SyncMethod3", "!!!", new SynchronisedMethodMessage());

        //syncWorker1.start();
        //syncWorker2.start();
        //syncWorker3.start();

        try {
            syncWorker1.start();
            syncWorker1.join();
            syncWorker2.start();
            syncWorker2.join();
            syncWorker3.start();
            syncWorker3.join();
            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Start synchronized block");

        Worker syncBlockWorker1 = new Worker("SyncBlock1", "Hello", new SynchronizedBlockMessage());
        Worker syncBlockWorker2= new Worker("SyncBlock2", "World", new SynchronizedBlockMessage());
        Worker syncBlockWorker3 = new Worker("SyncBlock3", "!!!", new SynchronizedBlockMessage());

        syncBlockWorker1.start();
        syncBlockWorker2.start();
        syncBlockWorker3.start();

        try {
            syncBlockWorker1.join();
            syncBlockWorker2.join();
            syncBlockWorker3.join();
            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
