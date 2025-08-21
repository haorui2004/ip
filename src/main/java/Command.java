public interface Command {
    void execute(TaskList tasks) throws CommandException;
}
