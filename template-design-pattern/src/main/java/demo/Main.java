package demo;

public class Main {
    public static void main(String[] args) {
        PizzaTemplate pizzaShop=new ChicagoPizza();
        pizzaShop.sellPizza();
        System.out.println("_______________________________");
        PizzaTemplate pizzaShoptwo=new NewYorkPizza();
        pizzaShoptwo.sellPizza();

    }
}
