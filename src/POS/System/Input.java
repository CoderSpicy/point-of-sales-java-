package POS.System;

import POS.Display;
import java.util.Scanner;

public class Input {
    public static int user;

    Input(int user){
        Input.user = user;
    }

    public static int MainMenu(Scanner scan){

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

        return user;
    }

    public static int Categories(Scanner scan){

        Display.Categories();

        do{
            try{
                System.out.print("Enter a number to proceed: ");
                user = scan.nextInt();

                if (user < 1 || user > 6) {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Numbers only.");
                scan.nextLine();
            }
        }while (user < 1 || user > 6);

        return user;
    }
}

