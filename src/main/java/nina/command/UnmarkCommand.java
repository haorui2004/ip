package nina.command;

import nina.CommandException;
import nina.task.TaskList;

public class UnmarkCommand implements Command {
    protected int index;

    /**
     * Constructs a UnmarkCommand object.
     *
     * @param index index of the task to be unmarked
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) throws CommandException {
        try{
            tasks.unmark(index);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("That task doesn't exist");
        }
    }
}
