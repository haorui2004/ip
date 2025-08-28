package nina.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventTask extends Task {
    protected LocalDate from;
    protected LocalDate to;
    private static final long serialVersionUID = 10L;

    public EventTask(String description, String from, String to) {
        super(description);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }

    @Override
    public String toSaveLine() {
        return basePrefix("E") + " | " + from.toString() + " | " + to.toString();
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))
                + " to: " + to.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }
}
