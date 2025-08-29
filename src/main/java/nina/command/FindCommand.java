package nina.command;

import nina.task.Task;
import nina.task.TaskList;

public class FindCommand implements Command{
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks) {
        System.out.println("Here are the matching tasks in your list:");
        int index = 1;
        for(Task t : tasks.items()) {
            if(t.match(keyword)) {
                System.out.println(index + "." + t);
                index++;
            }
        }
        if(index == 1) {
            System.out.println("No matching task is found");
        }
    }
}
