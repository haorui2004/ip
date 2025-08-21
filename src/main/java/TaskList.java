import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;

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

    public void showList() {
        if(!tasks.isEmpty()) {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
