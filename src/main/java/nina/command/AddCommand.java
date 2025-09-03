package nina.command;

import nina.task.Task;
import nina.task.TaskList;

public class AddCommand implements Command {
    protected Task task;

    /**
     * Constructs a AddCommand object.
     *
     * @param task task to be added into the tasks list
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public String execute(TaskList tasks) {
        tasks.addTask(task);
        return "Got it. I've added this task:\n"
                + task
                + "\nNow you have " + tasks.size() + " tasks in the list.";
    }
}
