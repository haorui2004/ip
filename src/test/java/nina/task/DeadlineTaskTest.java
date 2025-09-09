package nina.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTaskTest {
    @Test
    public void testToSaveLineStoresDateCorrectly() {
        DeadlineTask d = new DeadlineTask("return book", "2019-12-02");
        String expected = "D | 0 | return book | 2019-12-02";
        assertEquals(expected, d.toSaveableLine());
    }

    @Test
    void testToStringFormatsDateCorrectly() {
        DeadlineTask d = new DeadlineTask("return book", "2019-12-02");
        String expected = "[D][ ] return book (by: Dec 02 2019)";
        assertEquals(expected, d.toString());
    }
}
