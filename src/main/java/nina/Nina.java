package nina;

import nina.command.Command;
import nina.task.TaskList;

import java.util.Scanner;

public class Nina {
    static String line = "___________________________________\n";
    protected TaskList tasks;
    private Storage storage;
    private UI ui;

    /**
     * Creates a Nina chatbot object.
     * Initializes storage, read tasks from file, and sets up the UI.
     */
    public Nina() {
        this.storage = new Storage("data/Nina.txt");
        this.tasks = storage.read();
        this.ui = new UI();
    }

    /**
     * Runs the main program loop.
     * Displays a greeting, continuously reads user input,
     * parses it into a Command object, executes the command,
     * and saves the updated tasks. The loop terminates when the user
     * enters the bye command.
     */
    public void run() {
        ui.greet();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                ui.exit();
                break;
            }

            try {
                Command cmd = Parser.parse(input);
                System.out.print(line);
                cmd.execute(tasks);
                storage.write(tasks);
                System.out.print(line);
            } catch (CommandException e) {
                ui.showError("nina.command.Command error: " + e.getMessage());
            } catch (InvalidInputException i) {
                ui.showError("Input error: " + i.getMessage());
            }
        }
    }

    /**
     * Main entry point of the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        Nina test = new Nina();
        test.run();
    }
}
