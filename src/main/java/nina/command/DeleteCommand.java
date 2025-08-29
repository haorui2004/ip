package nina.command;

import nina.CommandException;
import nina.task.TaskList;

public class DeleteCommand implements Command {
    protected int index;

    /**
     * Constructs a DeleteCommand object.
     *
     * @param index index of the task to be deleted
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) throws CommandException {
        try{
            tasks.delete(index);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("That task doesn't exist");
        }
    }
}
