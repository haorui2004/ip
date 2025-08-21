public class Nina {
    static String line = "____________________________________\n";

    public static void greet() {
        System.out.println("Hello, I am your personal assistant Nina\n" +
                "What can I do for you?");
        System.out.print(line);
    }

    public static void exit() {
        System.out.println("See you again soon!");
        System.out.print(line);
    }

    public static void main(String[] args) {
        greet();
        exit();
    }
}
