package nina.command;

import nina.task.Task;
import nina.task.TaskList;

public class FindCommand implements Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList tasks) {
        StringBuilder sb = new StringBuilder("Here are the matching tasks in your list:\n");
        int index = 1;

        for (Task t : tasks.items()) {
            if (t.match(keyword)) {
                sb.append(index).append(". ").append(t).append("\n");
                index++;
            }
        }

        if (index == 1) {
            return "No matching task is found.";
        }

        return sb.toString().trim();
    }
}
