package nina;

import nina.task.Task;
import nina.task.TaskList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Storage {
    private final Path filePath;
    private final Path dirPath;

    public Storage(String path) {
        this.filePath = Paths.get(path).normalize();
        this.dirPath = filePath.getParent() == null ? Paths.get(".") : filePath.getParent();
    }

    private void ensureFile() throws IOException {
        if (Files.notExists(dirPath)) Files.createDirectories(dirPath);
        if (Files.notExists(filePath)) Files.createFile(filePath);
    }

    public TaskList read() {
        TaskList list = new TaskList();
        try {
            ensureFile();
            List<String> lines = Files.readAllLines(filePath);
            for (String raw : lines) {
                String line = raw.trim();
                if (!line.isEmpty()) {
                    list.addTask(Task.fromSaveLine(line));
                }
            }

        } catch (IOException e) {
            System.err.println("[nina.Storage] read error: " + e.getMessage());
        }
        return list;
    }

    public void write(TaskList tasksToStore) {
        try {
            ensureFile();
            try (BufferedWriter w = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                for (Task t : tasksToStore.items()) {
                    w.write(t.toSaveLine());
                    w.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("[nina.Storage] write error: " + e.getMessage());
        }
    }
}
