package nina;

import nina.command.*;
import nina.task.DeadlineTask;
import nina.task.EventTask;
import nina.task.TodoTask;

/**
 * Parses raw user input strings and convert them to corresponding commands
 */
public class Parser {

    /**
     * Parses a raw input string into a command object
     * @param str raw input from user
     * @return Command object corresponding to the input
     * @throws CommandException if the input is empty
     * @throws InvalidInputException if the input format is invalid
     */
    public static Command parse (String str) throws CommandException, InvalidInputException {
        if (str.isEmpty()) {
            throw new CommandException("The command is empty");
        }

        if (str.equals("list")) {
            return new ListCommand();
        }

        if (str.startsWith("mark ")) {
            String taskNo = str.substring(5).trim();
            try {
                int number = Integer.parseInt(taskNo);
                return new MarkCommand(number);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Only number can come after mark!");
            }
        }

        if (str.startsWith("unmark ")) {
            String taskNo = str.substring(7).trim();
            try {
                int number = Integer.parseInt(taskNo);
                return new UnmarkCommand(number);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Only number can come after unmark!");
            }
        }

        if (str.startsWith("todo ")) {
            String des = str.substring(5).trim();
            TodoTask td = new TodoTask(des);
            return new AddCommand(td);
        }

        if (str.startsWith("deadline ")) {
            String[] parts = str.substring(9).split("/by", 2);
            if (parts.length < 2) {
                throw new InvalidInputException("Please check the format of task input again!");
            }
            String des = parts[0].trim();
            String by = parts[1].trim();
            DeadlineTask ddl = new DeadlineTask(des, by);
            return new AddCommand(ddl);
        }

        if (str.startsWith("event ")) {
            String[] parts = str.substring(6).split("/from|/to");
            if (parts.length < 3) {
                throw new InvalidInputException("Please check the format of task input again!");
            }
            String des = parts[0].trim();
            String from = parts[1].trim();
            String to = parts[2].trim();
            EventTask ev = new EventTask(des, from, to);
            return new AddCommand(ev);
        }

        if (str.startsWith("delete ")) {
            String taskNo = str.substring(7).trim();
            try {
                int number = Integer.parseInt(taskNo);
                return new DeleteCommand(number);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Only number can come after delete!");
            }
        }

        throw new InvalidInputException("I cannot find the command OvO");
    }
}
