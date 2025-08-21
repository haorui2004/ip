public class AddCommand implements Command{
    protected String description;
    public AddCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks) {
        Task t = new Task(description);
        tasks.addTask(t);
        System.out.println("added: "+ description);
    }
}
