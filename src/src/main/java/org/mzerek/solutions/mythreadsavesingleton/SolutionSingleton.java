package org.mzerek.solutions.mythreadsavesingleton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.Serializable;

class MySingletonOne {

    private static MySingletonOne INSTANCE;

    private MySingletonOne() {
    }

    public static MySingletonOne getInstance() {
        if (INSTANCE == null) {
            synchronized (MySingletonOne.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MySingletonOne();
                }
            }
        }
        return INSTANCE;
    }

}

class MySingletonTwo implements Serializable {

    public static final long serialVersionUID = 1L;

    private MySingletonTwo() {
        if (SingletonLoader.INSTANCE != null) {
            throw new IllegalStateException("Singleton already exists");
        }
    }

    private static class SingletonLoader {
        private static final MySingletonTwo INSTANCE = new MySingletonTwo();
    }

    public static MySingletonTwo getInstance() {
        return SingletonLoader.INSTANCE;
    }

    protected MySingletonTwo readResolve() {
        return SingletonLoader.INSTANCE;
    }
}

//https://dzone.com/articles/java-singletons-using-enum
enum MySingletonEnum {

    INSTANCE;
}


public class SolutionSingleton {

    public static void main(String[] args) {

        //JUnitCore.main("Solution");


        Result result = JUnitCore.runClasses(SolutionSingleton.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }

    @Test
    public void addFirstTest() {
        //is
        MySingletonOne one = MySingletonOne.getInstance();
        MySingletonTwo two = MySingletonTwo.getInstance();
        MySingletonEnum myEnum = MySingletonEnum.INSTANCE;

        //when
        MySingletonOne oneA = MySingletonOne.getInstance();
        MySingletonTwo twoA = MySingletonTwo.getInstance();
        MySingletonEnum myEnumA = MySingletonEnum.INSTANCE;

        //expected

        Assert.assertEquals(one, oneA);
        Assert.assertEquals(one.hashCode(), oneA.hashCode());
        Assert.assertEquals(two, twoA);
        Assert.assertEquals(two.hashCode(), twoA.hashCode());
        Assert.assertEquals(myEnum, myEnumA);
        Assert.assertEquals(myEnum.hashCode(), myEnumA.hashCode());

    }
}
