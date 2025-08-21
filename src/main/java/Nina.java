import java.util.Scanner;
import java.util.ArrayList;

public class Nina {
    static String line = "___________________________________\n";
    static ArrayList<String> tasks = new ArrayList<>();

    public static void greet() {
        System.out.print(line);
        System.out.println("Hello, I am your personal assistant Nina\n" +
                "What can I do for you?");
        System.out.print(line);
    }

    public static void exit() {
        System.out.print(line);
        System.out.println("See you again soon!");
        System.out.print(line);
    }

    public void echo() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String command = sc.nextLine();

            if(command.equals("list")) {
                System.out.print(line);
                for(int i =0; i< tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
                System.out.print(line);
                continue;
            }

            tasks.add(command);

            if (command.equals("bye")) {
                exit();
                break;
            }

            System.out.print(line);
            System.out.println("added: "+ command);
            System.out.print(line);
        }
    }

    public static void main(String[] args) {
        Nina test = new Nina();
        greet();
        test.echo();
    }
}
