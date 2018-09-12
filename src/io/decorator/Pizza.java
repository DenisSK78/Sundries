package io.decorator;

public class Pizza extends PizzaIngredient {
    //Concrete decorator
    public Pizza(Ingredient ingredient) {
        super(ingredient);
    }

    @Override
    public Integer getCost() {
        return super.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return "Pizza with:" + super.getDescription();
    }
}
