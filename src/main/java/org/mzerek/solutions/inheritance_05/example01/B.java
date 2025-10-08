package main.java.org.mzerek.solutions.inheritance_05.example01;

public class B extends A {
    public B() {
        super("paramB_to_A");
        System.out.println("B");
    }

    public void methodB(){
        System.out.println("methodB");
    }
}
