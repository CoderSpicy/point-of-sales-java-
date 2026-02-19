package POS;

public class Categories {
    int id;
    String name;

    Categories(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static Categories[] categories = {
            new Categories(1, "Breakfast"),
            new Categories(2, "Main Course"),
            new Categories(3, "Dessert"),
            new Categories(4, "Snacks"),
            new Categories(5, "Appetizers"),
            new Categories(6, "Beverages")

    };
}
