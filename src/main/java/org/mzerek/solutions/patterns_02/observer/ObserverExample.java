package main.java.org.mzerek.solutions.patterns_02.observer;


// https://www.youtube.com/watch?v=gFevma4a_qQ
public class ObserverExample {

    public static void main(String[] args) {
        NotificationTask notificationTask = new NotificationTask();
        TaskForObservation taskForObservation = new TaskForObservation(notificationTask);
    }
}
