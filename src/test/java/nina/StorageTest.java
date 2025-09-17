package nina;

import nina.task.DeadlineTask;
import nina.task.TaskList;
import nina.task.TodoTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorageTest {
    @Test
    void testWriteAndRead(@TempDir Path tempDir) throws Exception {
        //suggested by Chatgpt to use TempDir instead of createTempFile
        Path storageTestFile = tempDir.resolve("storageTest.txt");
        Storage storage = new Storage(storageTestFile.toString());

        TaskList original = new TaskList();
        original.addTask(new TodoTask("read book"));
        original.addTask(new DeadlineTask("return book", "2019-12-02"));

        storage.write(original);
        TaskList loaded = storage.read();

        assertEquals(2, loaded.size());
        assertTrue(loaded.get(0) instanceof TodoTask);
        assertTrue(loaded.get(1) instanceof DeadlineTask);

        assertEquals(original.get(0).toString(), loaded.get(0).toString());
        assertEquals(original.get(1).toString(), loaded.get(1).toString());

        assertTrue(Files.exists(storageTestFile));
    }
}
