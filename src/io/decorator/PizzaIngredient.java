package io.decorator;

public class PizzaIngredient implements Ingredient {
    //Decorator
    private final Ingredient ingredient;

    public PizzaIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public Integer getCost() {
        return ingredient.getCost();
    }

    @Override
    public String getDescription() {
        return ingredient.getDescription();
    }
}
