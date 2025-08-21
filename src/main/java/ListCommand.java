public class ListCommand implements Command {
    @Override
    public void execute(TaskList tasks) {
        tasks.showList();
    }
}
