package POS;

import POS.System.Input;
import java.util.Scanner;

import static POS.Display.ConfirmationExit;
import static POS.System.Input.user;


public class Main {
    static Scanner scan = new Scanner(System.in);
    public static boolean running = true;

    public static void main(String[] args) {
        while (running) {
            Input.MainMenu(scan);
            Menu();
        }
    }

    static void Menu(){
        switch (user) {
            case 1 -> Display.CategorySelection(user, scan);
            case 2 -> Display.ViewOrder(scan);
            case 3 -> ConfirmationExit(scan);
        }
    }
}