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

            try {
                Command cmd = createCommand(input);
                System.out.print(line);
                cmd.execute(tasks);
                System.out.print(line);
            } catch (CommandException e) {
                System.out.println("Command error: " + e.getMessage());
            } catch (InvalidInputException i) {
                System.out.println("Input error: " + i.getMessage());
            }
        }
    }

    public Command createCommand(String str) throws CommandException, InvalidInputException{
        if(str.isEmpty()) {
            throw new CommandException("The command is empty");
        }

        if(str.equals("list")) {
            return new ListCommand();
        }

        if(str.startsWith("mark ")) {
            return new MarkCommand(Integer.parseInt(str.substring(5).trim()));
        }

        if(str.startsWith("unmark ")) {
            return new UnmarkCommand(Integer.parseInt(str.substring(7).trim()));
        }

        if(str.startsWith("todo ")) {
            String des = str.substring(5).trim();
            TodoTask td = new TodoTask(des);
            return new AddCommand(td);
        }

        if(str.startsWith("deadline ")) {
            String[] parts = str.substring(9).split("/by", 2);
            if(parts.length < 2) {
                throw new InvalidInputException("Please check the format of task input again!");
            }
            String des = parts[0].trim();
            String by = parts[1].trim();
            DeadlineTask ddl = new DeadlineTask(des, by);
            return new AddCommand(ddl);
        }

        if(str.startsWith("event ")) {
            String[] parts = str.substring(6).split("/from|/to");
            if(parts.length < 3) {
                throw new InvalidInputException("Please check the format of task input again!");
            }
            String des = parts[0].trim();
            String from = parts[1].trim();
            String to = parts[2].trim();
            EventTask ev = new EventTask(des, from, to);
            return new AddCommand(ev);
        }

        throw new InvalidInputException("Invalid input");
    }

    public static void main(String[] args) {
        Nina test = new Nina();
        test.greet();
        test.run();
    }
}
