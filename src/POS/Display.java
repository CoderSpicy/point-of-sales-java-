package POS;

import POS.System.Cart;
import POS.System.Input;

import javax.swing.text.View;
import java.util.Scanner;

import static POS.Categories.categories;

public class Display {

    public static void MainMenu(){
        System.out.println("-------\"Main Menu\"-------");
        System.out.println("1. Add order");
        System.out.println("2. View order");
        System.out.println("3. Exit");
    }

    public static void Categories(){
        System.out.println("-------\"Categories\"-------");
        for (int i = 0; i < categories.length; i++){
            System.out.println((i + 1) + ". " + categories[i].name);
        }
    }

    public static void CategoriesBanner(int user, Scanner scan) {
        for (int i = 0; i < categories.length; i++) {
            if (user == categories[i].id) {
                System.out.println("-------\"" + categories[i].name + "\"-------");
            }
        }
    }

    public static void Product(int user, Scanner scan) {
        int productNumber = 1;
        for (int i = 0; i < Product.products.length; i++) {
            if (user == Product.products[i].categoriesId) {
                System.out.println(productNumber + ". " + Product.products[i].name + " - " + Product.products[i].price);
                productNumber++;
            }
        }
    }

    public static void Confirmation(Product product, int quantity, Scanner scan) {

        System.out.println("Product: " + product.name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + product.price * quantity);
        System.out.println("------------------------------");
        System.out.println("Are you sure you want to add this to your order?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int confirmation = Input.Confirmation(scan);

        if (confirmation == 1) {
            Cart.addToCart(product.name, quantity, product.price);
            System.out.println("Added to cart!");
            CategorySelection(1, scan);
        }
        else{
            System.out.println("Order cancelled.");
            CategorySelection(1, scan);
        }
    }

    public static void CartOption(Scanner scan){
        System.out.println("-------\"Options\"-------");
        System.out.println("1. Remove item");
        System.out.println("2. Clear cart");
        System.out.println("3. Checkout");
        System.out.println("4. back");


        int option = Input.CartOption(scan);

        switch (option) {
            case 1 -> {
                int itemNumber = Input.RemoveItem(scan);
                if (itemNumber == 0) {
                    ViewOrder(scan);
                } else {
                    ConfirmationRemoveItem(itemNumber);
                    int choice = Input.Confirmation(scan);
                    if (choice == 2) {
                        System.out.println("Item removal cancelled. Returning to order view.");
                        ViewOrder(scan);
                        return;
                    }
                    Cart.RemoveItem(itemNumber - 1);
                    System.out.println("Item removed.");
                    ViewOrder(scan);
                }
            }
            case 2 -> {
                ConfirmClear();
                int choice = Input.Confirmation(scan);

                if (choice == 1){
                    Cart.ClearItem();
                    ClearItem();
                } else {
                    System.out.println("Clear cancelled. Returning to order view.");
                    ViewOrder(scan);
                }
            }
            case 3 -> {
                ConfirmationChechout();
                int choice = Input.Confirmation(scan);

                if (choice == 1){
                    double paid = Input.Transaction(scan);
                    if (paid == 0){
                        System.out.println("Checkout cancelled. Returning to order view.");
                    } else {
                        Reciept(scan);
                    }
                } else {
                    System.out.println("Checkout cancelled. Returning to order view.");
                    ViewOrder(scan);
                }
            }
            case 4 -> {
                System.out.println("Returning to main menu.");
                return;
            }
            default -> System.out.println("Invalid option. Returning to main menu.");
        }

    }

    public static void ViewOrder(Scanner scan) {
        System.out.println("-------\"Your Order\"-------");
        Cart.total = 0;
        for (int i = 0; i < Cart.productName.size(); i++) {
            System.out.println((i + 1) + ". " + Cart.productName.get(i) + " - ₱" + Cart.price.get(i) + " (" + Cart.quantity.get(i) + ") - ₱" + (Cart.quantity.get(i) * Cart.price.get(i)));
            Cart.total += (Cart.quantity.get(i) * Cart.price.get(i));
        }
        if (!Cart.productName.isEmpty()) {
            System.out.println("Total: " + Cart.total);
            CartOption(scan);
        } else {
            System.out.println("Your order is empty.");
        }
    }

    public static void ConfirmClear(){
        System.out.println("Are you sure you want to clear all orders?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public static void ClearItem(){
        System.out.println("------------------------------");
        System.out.println("All orders have been cleared!");
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

    static void ProductSelection(int choice, Scanner scan) {
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

    public static void ConfirmationChechout(){
        System.out.println("-------\"Checkout\"-------");
        System.out.println("Would you like to proceed with checkout?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public static void Transaction(){
        System.out.print("Please enter the cash payment amount. (Enter 0 to cancel): ");
    }

    static void Reciept(Scanner scan){
        System.out.println("-------\"Reciept\"-------");
        for (int i = 0; i < Cart.productName.size(); i++) {
            System.out.println((i + 1) + ". " + Cart.productName.get(i) + " - " + Cart.quantity.get(i) + " - " + Cart.price.get(i));
        }
        System.out.println("Total: " + Cart.total);

        if (Cart.cash > Cart.total) {
            System.out.println("Change: " + (Cart.Change()));
        }
        System.out.println("Thank you for your purchase!");
        Cart.ClearItem();
    }

    static void ConfirmationRemoveItem(int index){
        index = index - 1;
        System.out.println("Are you sure you want to remove " + Cart.productName.get(index) + " from your order?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }
}
