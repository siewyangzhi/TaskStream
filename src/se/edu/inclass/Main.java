package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

        System.out.println("Printing deadlines");
        printDeadlines(tasksData);
        //printDataWithStreams(tasksData);
        printDeadlinesWithStreams(tasksData);
        //System.out.println("Total number of deadlines: " + countDeadlines(tasksData));
        System.out.println("Total number of deadlines: " +
                countDeadlinesWithStream(tasksData));


    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesWithStream(ArrayList<Task> tasksData){
        int count  = 0;
        count = (int) tasksData.stream()
                .filter(t -> t instanceof Deadline)
                .count();
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t); //Method call from System package out object and println method
        }
    }

    public static void printDataWithStreams(ArrayList<Task> tasksData) {
        System.out.println("\n Print tasks using streams");
        tasksData.stream()// Converts tasksData to Stream
                .forEach(System.out::println);//Terminal operation
        // System.out::println means that we are passing the reference to the method of the out object within the System package.
        //This is because the programmer is not calling the println method but we are simply asking the streams to call that method themselves behind the scene.
        //This is due to the fact that Streams does the processing behind the scene, we simply tell them what we want them to do and pass them the resources.
        // System.out::println is considered as the consumer since it is taken in by the streams and applied to the data within the stream.
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesWithStreams(ArrayList<Task> tasksData) {
        System.out.println("\n Printing deadlines using stream");
        tasksData.stream()
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);
    }
}
