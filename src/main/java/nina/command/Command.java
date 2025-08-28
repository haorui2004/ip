package nina.command;

import nina.CommandException;
import nina.task.TaskList;

public interface Command {
    void execute(TaskList tasks) throws CommandException;
}
