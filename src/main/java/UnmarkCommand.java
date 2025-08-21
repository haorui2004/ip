public class UnmarkCommand implements Command{
    protected int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) {
        tasks.unmark(index);
    }
}
