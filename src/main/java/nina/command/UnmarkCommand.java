package nina.command;

import nina.CommandException;
import nina.task.TaskList;

public class UnmarkCommand implements Command {
    protected int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) throws CommandException {
        try {
            tasks.unmark(index);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("That task doesn't exist");
        }
    }
}
