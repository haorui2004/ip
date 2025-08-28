public class DeadlineTask extends Task{

    protected String by;
    private static final long serialVersionUID = 10L;

    public DeadlineTask(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toSaveLine() {
        return basePrefix("D") + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }
}
