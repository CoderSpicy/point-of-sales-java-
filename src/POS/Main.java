package POS;

import POS.System.Input;

import static POS.System.Input.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MainMenu(scan);
        switch (user) {
            case 1:
                CategorySelection(user, scan);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user);
        }
    }

    private static void CategorySelection(int user, Scanner scan) {
        switch (user) {
            case 1:
                int choice = Input.Categories(scan);
                ProductSelection(choice, scan);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user);
        }
    }



    private static void ProductSelection(int choice, Scanner scan) {
        Display.CategoriesBanner(choice, scan);
        Display.Product(choice, scan);
    }
}
