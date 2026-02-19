package POS;

import POS.System.Input;

import static POS.System.Input.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean running = true;
        while (running) {
                MainMenu(scan);
                switch (user) {
                    case 1 -> CategorySelection(user, scan);
                    case 2 -> Display.ViewOrder(scan);
                    case 3 -> System.out.println("Checkout");
                    case 4 -> {
                        System.out.println("Exit");
                        running = false;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + user);
                }
        }
    }

    static void CategorySelection(int user, Scanner scan) {
        switch (user) {
            case 1 -> {
                int choice = Input.Categories(scan);
                if (choice == 0) {
                    return;
                } else {
                    ProductSelection(choice, scan);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + user);
        }
    }

    private static void ProductSelection(int choice, Scanner scan) {
        Display.CategoriesBanner(choice, scan);

        int productChoice = Input.Product(choice, scan);

        if (productChoice == 0) {
            CategorySelection(1, scan);
        } else {
            int count = 0;
            for (int i = 0; i < Product.products.length; i++) {
                if (choice == Product.products[i].categoriesId) {
                    count++;
                    if (count == productChoice) {
                        int quantity = Input.Quantity(scan);
                        System.out.println("------------------------------");
                        Display.Confirmation(Product.products[i], quantity, scan);

                        break;
                    }
                }
            }
        }
    }
}
