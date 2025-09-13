package main.java.org.mzerek.solutions.javathreads_01.thread_runnable;

/*
https://www.samouczekprogramisty.pl/watki-w-jezyku-java/
 */
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("MT start");

        // Thread class
        Thread threadExample = new ThreadExample();
        threadExample.start();

        // Thread with Runnable interface
        Thread threadRunnable = new Thread(new RunnableExample());
        threadRunnable.start();

        // Thread with anonymous class
        Thread threadAnonymous = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside thread T1");
                System.out.println("T1 start");
                for (int i =0; i<5; i++){
                    System.out.println("T1 " + i);
                }
                System.out.println("T1 stop");
            }
        });
        threadAnonymous.start();

        // Thread with lambda
        Thread threadLambda = new Thread(() -> {
                System.out.println("Inside thread T2");
                System.out.println("T2 start");
                for (int i =0; i<5; i++){
                    System.out.println("T2 " + i);
                }
                System.out.println("T2 stop");
        });
        threadLambda.start();

        for (int i =0; i<5; i++){
            System.out.println("MT " + i);
        }
        System.out.println("MT stop");
    }
}