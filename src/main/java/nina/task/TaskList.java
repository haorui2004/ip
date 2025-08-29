package nina.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a list of Task objects.
 */
public class TaskList implements Serializable {
    protected ArrayList<Task> tasks;
    private static final long serialVersionUID = 10L;

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list.
     *
     * @param t the task to add
     */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /**
     * Marks the task at the given position as done and prints confirmation.
     *
     * @param number index of the task to mark
     */
    public void mark(int number) {
        Task t = tasks.get(number - 1);
        t.markDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.print("  " + t + "\n");
    }

    /**
     * Marks the task at the given position as not done and prints confirmation.
     *
     * @param number index of the task to mark
     */
    public void unmark(int number) {
        Task t = tasks.get(number - 1);
        t.unmarkDone();
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.print("  " + t + "\n");
    }

    /**
     * Returns the number of tasks in the list
     *
     * @return the total number of tasks in the list
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Retrieves the task at the specified index.
     *
     * @param index of the task to be extracted from the list
     * @return the Task object with the same index
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Deletes the task at the given position and prints confirmation.
     *
     * @param number index of the task to delete
     */
    public void delete(int number) {
        Task t = tasks.remove(number - 1);
        System.out.println("Noted. I've removed this task:\n");
        System.out.print("  " + t + "\n");
    }

    /**
     * Prints the list of tasks.
     * If the list is empty, nothing will be printed.
     */
    public void showList() {
        if(!tasks.isEmpty()) {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    /**
     * Returns an unmodifiable iterable view of the tasks.
     *
     * @return an iterable collection of tasks
     */
    public Iterable<Task> items() {
        return Collections.unmodifiableList(tasks);
    }
}
