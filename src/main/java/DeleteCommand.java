public class DeleteCommand implements Command{
    protected int index;
    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) throws CommandException{
        try{
            tasks.delete(index);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("That task doesn't exist");
        }
    }
}
