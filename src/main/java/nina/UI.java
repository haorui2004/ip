package nina;

public class UI {
    static String line = "___________________________________\n";

    public void greet() {
        System.out.print(line);
        System.out.println("Hello, I am your personal assistant nina.Nina\n" +
                "What can I do for you?");
        System.out.print(line);
    }

    public void exit() {
        System.out.print(line);
        System.out.println("See you again soon!");
        System.out.print(line);
    }

    public void showError(String msg) {
        System.out.println("OOPS!!! " + msg);
    }

}
