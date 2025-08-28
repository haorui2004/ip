package nina.command;

import nina.task.Task;
import nina.task.TaskList;

public class AddCommand implements Command {
    protected Task task;
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.addTask(task);
        System.out.println("Got it. I've added this task:\n" + task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
