import java.util.Scanner;

public class Nina {
    static String line = "___________________________________\n";

    public static void greet() {
        System.out.println("Hello, I am your personal assistant Nina\n" +
                "What can I do for you?");
        System.out.print(line);
    }

    public static void exit() {
        System.out.println("See you again soon!");
        System.out.print(line);
    }

    public void echo() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                exit();
                break;
            }
            System.out.println(command);
            System.out.print(line);
        }
    }

    public static void main(String[] args) {
        Nina test = new Nina();
        greet();
        test.echo();
    }
}
