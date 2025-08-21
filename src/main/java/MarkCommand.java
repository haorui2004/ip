public class MarkCommand implements Command{
    protected int index;
    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) throws CommandException{
        try{
            tasks.mark(index);
        } catch (IndexOutOfBoundsException e){
            throw new CommandException("That task doesn't exist");
        }
    }
}
