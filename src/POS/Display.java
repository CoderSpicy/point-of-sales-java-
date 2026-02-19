package POS;

import POS.System.Input;

import java.util.Scanner;

import static POS.Categories.categories;
import static POS.Main.CategorySelection;

public class Display {

    public static void MainMenu(){
        System.out.println("-------\"Main Menu\"-------");
        System.out.println("1. Add order");
        System.out.println("2. View order");
        System.out.println("3. Checkout");
        System.out.println("4. Exit");
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
            System.out.println("Added to cart!");
            CategorySelection(1, scan);
        }
        else{
            System.out.println("Order cancelled.");
            CategorySelection(1, scan);
        }

    }
}
