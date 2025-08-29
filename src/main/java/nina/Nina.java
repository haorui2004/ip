package nina;

import nina.command.Command;
import nina.task.TaskList;

import java.util.Scanner;

public class Nina {
    static String LINE = "___________________________________\n";
    private TaskList tasks;
    private Storage storage;
    private UI ui;
    private static final String STORAGE_FILE_PATH = "data/nina.Nina.txt";

    public Nina() {
        this.storage = new Storage(STORAGE_FILE_PATH);
        this.tasks = storage.read();
        this.ui = new UI();
    }

    public void run() {
        ui.greet();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                ui.exit();
                break;
            }

            try {
                Command cmd = Parser.parse(input);
                System.out.print(LINE);
                cmd.execute(tasks);
                storage.write(tasks);
                System.out.print(LINE);
            } catch (CommandException e) {
                ui.showError("nina.command.Command error: " + e.getMessage());
            } catch (InvalidInputException i) {
                ui.showError("Input error: " + i.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Nina test = new Nina();
        test.run();
    }
}
