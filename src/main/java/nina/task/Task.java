package nina.task;

import java.io.Serializable;

public abstract class Task implements Serializable {
    protected String description;
    protected boolean isDone;
    private static final long serialVersionUID = 10L;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markDone() {
        isDone = true;
    }

    public void unmarkDone(){
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    protected String basePrefix(String type) {
        return type + " | " + (isDone ? "1" : "0") + " | " + description;
    }

    public abstract String toSaveLine();

    public static Task fromSaveLine(String line) {
        String[] p = line.split("\\|");
        for (int i = 0; i < p.length; i++) {
            p[i] = p[i].trim();
        }
        if (p.length < 3) throw new IllegalArgumentException("Bad line: " + line);

        String type = p[0];
        boolean done = "1".equals(p[1]);
        String des = p[2];

        Task t;
        switch (type) {
            case "T":
                if (p.length != 3) throw new IllegalArgumentException("Todo needs 3 fields");
                t = new TodoTask(des);
                break;
            case "D":
                if (p.length != 4) throw new IllegalArgumentException("Deadline needs 4 fields");
                t = new DeadlineTask(des, p[3]);
                break;
            case "E":
                if (p.length != 5) throw new IllegalArgumentException("Event needs 5 fields");
                t = new EventTask(des, p[3], p[4]);
                break;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
        if (done) t.markDone();
        return t;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + description;
    }
}
