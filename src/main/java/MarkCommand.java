public class MarkCommand implements Command{
    protected int index;
    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.mark(index);
    }
}
