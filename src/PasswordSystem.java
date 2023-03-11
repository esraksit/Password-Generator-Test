import java.util.Scanner;

public class PasswordSystem {

public static final Scanner keyboard = new Scanner(System.in);

public static void main(String[] args) {
        Generator generator = new Generator(keyboard);
        System.out.println("Welcome to Ziz Password Services :)");
        generator.printMenu();
        String userOption = "-1";
        userOption = keyboard.next();
        generator.mainLoop(userOption);
        keyboard.close();
        }
}
