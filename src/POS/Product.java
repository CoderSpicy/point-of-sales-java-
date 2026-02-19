package POS;

public class Product {
    int id;
    String name;
    double price;
    public int categoriesId;

    Product(int id, String name, double price, int categoriesId){
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoriesId = categoriesId;
    }

    public static Product[] products = {
            //Breakfast (1)
            new Product(1, "Ham and Cheese Omelette", 220.0, 1),
            new Product(2, "Nutella Stuffed Pancakes", 150.0, 1),
            new Product(3, "Bacon, Egg and Mushroom Tart", 230.0, 1),
            new Product(4, "Scrambled eggs", 130.0, 1),
            new Product(5, "Ham Cheese French Toast", 200.0, 1),
            new Product(6, "Cheese and Bacon Strata Cake", 270.0, 1),
            //Main Course (2)
            new Product(1, "Sizzling Sisig Kapampangan", 370.0, 2),
            new Product(2, "Grilled Steak with roasted veggies", 432.0, 2),
            new Product(3, "Beef Caldereta with liver spread", 386.0, 2),
            new Product(4, "Pork BBQ Skewers", 174.0, 2),
            new Product(5, "Korean-style BBQ Beef with Kimchi", 340.0, 2),
            new Product(6, "Seared Scallops with lemon butter sauce", 515.0, 2),
            new Product(7, "Vegetarian Stuffed Bell Peppers (w/ Quinoa)", 256.0, 2),
            //Dessert (3)
            new Product(1, "Leche Flan", 120.0, 3),
            new Product(2, "Ube Cake", 155.0, 3),
            new Product(3, "Chocolate Mousse", 238.0, 3),
            new Product(4, "Tiramisu", 255.0, 3),
            new Product(5, "Crepes", 147.0, 3),
            new Product(6, "Pecan Pie", 227.0, 3),
            new Product(7, "Baklava", 156.0, 3),
            //Snacks (4)
            new Product(1, "Sweet Bagel Chips", 152.0, 4),
            new Product(2, "Roasted Veggie Chips", 118.0, 4),
            new Product(3, "Fruit Dip", 79.0, 4),
            new Product(4, "Berries Bagel", 209.0, 4),
            new Product(5, "Caramel Popcorn", 115.0, 4),
            new Product(6, "Caprese Avocado Toast", 259.0, 4),
            //Appetizers (5)
            new Product(1, "Meatballs", 178.0, 5),
            new Product(2, "Garlic Noodles", 125.0, 5),
            new Product(3, "Mozarella Sticks", 164.0, 5),
            new Product(4, "Stuffed Mushrooms", 180.0, 5),
            new Product(5, "Chicharon Bulaklak A La Carte", 133.0, 5),
            new Product(6, "Grilled Octopus", 266.0, 5),
            new Product(7, "Boneless Chicken", 169.0, 5),
            //Beverages (6)
    };
}
