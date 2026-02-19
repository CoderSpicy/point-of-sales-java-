package POS.System;

import POS.Display;
import POS.Product;

import java.util.Scanner;

public class Input {
    public static int user;

    Input(int user){
        Input.user = user;
    }

    public static void MainMenu(Scanner scan){

        Display.MainMenu();

        do{
            try{
                System.out.print("Enter a number to proceed: ");
                user = scan.nextInt();

                if (user < 1 || user > 4) {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Numbers only.");
                scan.nextLine();
            }
        }while (user < 1 || user > 4);

    }

    public static int Categories(Scanner scan){

        Display.Categories();

        do{
            try{
                System.out.print("Enter a number to proceed (or 0 to go back): ");
                user = scan.nextInt();

                if (user < 1 || user > 6) {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Numbers only.");
                scan.nextLine();
            }
        }while (user < 0 || user > 6);

        return user;
    }

    public static int countProducts(int categoryId) {
        int count = 0;
        for (int i = 0; i < Product.products.length; i++) {
            if (Product.products[i].categoriesId == categoryId) {
                count++;
            }
        }
        return count;
    }

    public static int Product(int categoryId, Scanner scan){
        Display.Product(categoryId, scan);

        int productCount = countProducts(categoryId);
        int user = 0;

        do{
            try{
                System.out.print("Enter a number to proceed (or 0 to go back): ");
                user = scan.nextInt();

                if (user < 0 || user > productCount) {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Numbers only.");
                scan.nextLine();
            }
        }while (user < 0 || user > productCount);

        return user;
    }

    public static int Quantity(Scanner scan){
        int quantity = 0;

        do{
            try{
                System.out.print("Enter quantity: ");
                quantity = scan.nextInt();

                if (quantity < 1) {
                    System.out.println("Quantity must be at least 1. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Numbers only.");
                scan.nextLine();
            }
        }while (quantity < 1);

        return quantity;
    }

    public static int Confirmation(Scanner scan){
        int user = 0;

        do{
            try{
                System.out.print("Enter a number to proceed: ");
                user = scan.nextInt();

                if (user < 1 || user > 2) {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Numbers only.");
                scan.nextLine();
            }
        }while (user < 1 || user > 2);

        return user;
    }

    public static int CartOption(Scanner scan){
        int user = 0;

        do{
            try{
                System.out.print("Select an option: ");
                user = scan.nextInt();

                if (user < 1 || user > 4) {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Numbers only.");
                scan.nextLine();
            }
        }while (user < 1 || user > 4);

        return user;
    }

    public static int RemoveItem(Scanner scan){
        int user = -1;

        do{
            try{
                System.out.print("Enter item number to remove (or 0 to go back): ");
                user = scan.nextInt();

                if (user < 0 || user > Cart.productName.size()) {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Numbers only.");
                scan.nextLine();
            }
        }while (user < 0 || user > Cart.productName.size());

        return user;
    }
}

