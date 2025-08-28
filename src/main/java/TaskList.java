import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {
    protected ArrayList<Task> tasks;
    private static final long serialVersionUID = 10L;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public void mark(int number) {
        Task t = tasks.get(number - 1);
        t.markDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.print("  " + t + "\n");
    }

    public void unmark(int number) {
        Task t = tasks.get(number - 1);
        t.unmarkDone();
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.print("  " + t + "\n");
    }

    public int size() {
        return tasks.size();
    }

    public void delete(int number) {
        Task t = tasks.remove(number - 1);
        System.out.println("Noted. I've removed this task:\n");
        System.out.print("  " + t + "\n");
    }

    public void showList() {
        if(!tasks.isEmpty()) {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public java.lang.Iterable<Task> items() {
        return java.util.Collections.unmodifiableList(tasks);
    }
}
