package nina;

/**
 * Handles user interactions with the program
 */
public class UI {
    private static String line = "___________________________________\n";

    /**
     * Prints the greeting message when the program starts.
     */
    public void greet() {
        System.out.print(line);
        System.out.println("Hello, I am your personal assistant nina.Nina\n" +
                "What can I do for you?");
        System.out.print(line);
    }

    /**
     * Prints the exit message when the program is about to terminate.
     */
    public void exit() {
        System.out.print(line);
        System.out.println("See you again soon!");
        System.out.print(line);
    }

    /**
     * Prints an error message to inform the user of invalid input or issues.
     *
     * @param msg The error message to be displayed
     */
    public void showError(String msg) {
        System.out.println("OOPS!!! " + msg);
    }

}
