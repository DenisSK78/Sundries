package io.decorator;

public class Cook {
    public static void main(String[] args) {
        //Pattern decorator
        Pizza pizza = new Pizza(new Ham(new Ches(new Mushrooms(new Tomato()))));
        System.out.println(pizza.getDescription());
        System.out.println("Price: " + pizza.getCost());
    }
}
