package nina.command;

import nina.task.TaskList;

public class ListCommand implements Command {
    @Override
    public String execute(TaskList tasks) {
        return tasks.showList();
    }
}
