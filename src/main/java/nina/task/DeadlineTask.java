package nina.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task {

    protected LocalDate by;
    private static final long serialVersionUID = 10L;

    /**
     * Constructs a DeadlineTask object
     *
     * @param description description of the task
     * @param by the deadline time of the task
     */
    public DeadlineTask(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
    }

    @Override
    public String toSaveLine() {
        return basePrefix("D") + " | " + by.toString();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))  + ")";
    }
}
