package nina.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a DeadlineTask with description and by date
 */
public class DeadlineTask extends Task {

    protected LocalDate by;
    private static final long serialVersionUID = 10L;

    /**
     * Constructs a DeadlineTask object
     *
     * @param description description of the task
     * @param by the deadline date of the task, in ISO format, YYYY-MM-DD
     */
    public DeadlineTask(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
    }

    @Override
    public String toSaveableLine() {
        return basePrefix("D") + " | " + by.toString();
    }

    @Override
    public String deDupKey() {
        return this.getClass().getName() + "|" + normalizeKey(this.description) + "|" + this.by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))  + ")";
    }
}
