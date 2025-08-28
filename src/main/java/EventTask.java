public class EventTask extends Task{
    protected String from;
    protected String to;
    private static final long serialVersionUID = 10L;

    public EventTask(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toSaveLine() {
        return basePrefix("E") + " | " + from + " | " + to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }
}
