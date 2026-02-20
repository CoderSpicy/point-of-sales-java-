package POS.System;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    public static ArrayList<String> productName = new ArrayList<>();
    public static ArrayList<Integer> quantity = new ArrayList<>();
    public static ArrayList<Double> price = new ArrayList<>();
    public static double cash = 0;
    public static double total = 0;


    public static void addToCart(String name, int quantity, double price) {
        Cart.productName.add(name);
        Cart.quantity.add(quantity);
        Cart.price.add(price);
    }

    public static void RemoveItem(int index) {
        if (index >= 0 && index < productName.size()) {
            productName.remove(index);
            quantity.remove(index);
            price.remove(index);
        } else {
            System.out.println("Invalid item index.");
        }
    }

    public static void ClearItem(){
        productName.clear();
        quantity.clear();
        price.clear();
        total = 0;
    }

    public static double Change(Scanner scan){
        return cash - total;
    }
}
