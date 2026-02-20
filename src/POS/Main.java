package POS;

import POS.System.Input;
import java.util.Scanner;
import static POS.System.Input.user;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean running = true;
        while (running) {
                Input.MainMenu(scan);
                switch (user) {
                    case 1 -> Display.CategorySelection(user, scan);
                    case 2 -> Display.ViewOrder(scan);
                    case 3 -> {
                        System.out.println("Exit");
                        running = false;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + user);
                }
        }
    }
}
