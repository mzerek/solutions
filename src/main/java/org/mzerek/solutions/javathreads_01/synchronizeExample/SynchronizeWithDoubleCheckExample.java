package main.java.org.mzerek.solutions.javathreads_01.synchronizeExample;

//https://czub.info/2016/java-8-wielowatkowosc-cz1-wstep-theread-synchronizacja/
public class SynchronizeWithDoubleCheckExample {

    private class Worker extends Thread{

        public Worker(String name){
            super(name);
        }

        @Override
        public void run(){
            final DoubleCheckedLocking instance = DoubleCheckedLocking.getInstance();
            instance.print();
        }
    }

    public static void main(String[] args){
        SynchronizeWithDoubleCheckExample example = new SynchronizeWithDoubleCheckExample();
        example.test();
    }

    private void test(){

        Worker worker = new Worker("Worker1");
        Worker worker2 = new Worker("Worker2");
        Worker worker3 = new Worker("Worker3");

        try{
            worker.start();
            worker.join();
            worker2.start();
            worker2.join();
            worker3.start();
            worker3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
