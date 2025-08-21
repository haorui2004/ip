import java.util.Scanner;

public class Nina {
    static String line = "___________________________________\n";
    protected TaskList tasks;

    public Nina() {
        tasks = new TaskList();
    }

    public void greet() {
        System.out.print(line);
        System.out.println("Hello, I am your personal assistant Nina\n" +
                "What can I do for you?");
        System.out.print(line);
    }

    public void exit() {
        System.out.print(line);
        System.out.println("See you again soon!");
        System.out.print(line);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                this.exit();
                break;
            }

            Command cmd = createCommand(input);
            System.out.print(line);
            cmd.execute(tasks);
            System.out.print(line);
        }
    }

    public Command createCommand(String str) {
        if(str.equals("list")) {
            return new ListCommand();
        }

        if(str.startsWith("mark ")) {
            return new MarkCommand(Integer.parseInt(str.substring(5).trim()));
        }

        if(str.startsWith("unmark ")) {
            return new UnmarkCommand(Integer.parseInt(str.substring(7).trim()));
        }
        return new AddCommand(str);
    }

    public static void main(String[] args) {
        Nina test = new Nina();
        test.greet();
        test.run();
    }
}
