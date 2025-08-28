public class TodoTask extends Task{
    private static final long serialVersionUID = 10L;

    public TodoTask(String description) {
        super(description);
    }

    @Override
    public String toSaveLine() {
        return basePrefix("T");
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
