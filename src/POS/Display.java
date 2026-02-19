package POS;

import java.util.Scanner;

import static POS.Categories.categories;

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
        for (int i = 0; i < Product.products.length; i++) {
            if (user == Product.products[i].categoriesId) {
                System.out.println((i + 1) + ". " + Product.products[i].name + " - " + Product.products[i].price);
            }
        }
    }
}
