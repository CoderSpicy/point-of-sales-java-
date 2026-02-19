package POS;

public class Product {
    int id;
    String name;
    double price;
    int categoriesId;

    Product(int id, String name, double price, int categoriesId){
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoriesId = categoriesId;
    }

    static Product[] products = {
            //Breakfast (1)
            new Product(1, "", 20.0, 1),
            new Product(2, "", 25.0, 1),
            //Main Course (2)

            //Dessert (3)

            //Snacks (4)

            //Appetizers (5)

            //Beverages (6)
    };
}
