package nina.command;

import nina.CommandException;
import nina.task.TaskList;

public class MarkCommand implements Command {
    protected int index;

    /**
     * Constructs a MarkCommand object.
     *
     * @param index index of the task to be marked
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) throws CommandException {
        try{
            tasks.mark(index);
        } catch (IndexOutOfBoundsException e){
            throw new CommandException("That task doesn't exist");
        }
    }
}
