package io.decorator;

public class Mushrooms extends PizzaIngredient {
    //Concrete decorator
    public Mushrooms(Ingredient ingredient) {
        super(ingredient);
    }

    @Override
    public Integer getCost() {
        return super.getCost()+5;
    }

    @Override
    public String getDescription() {
        return " mushrooms," + super.getDescription();
    }
}
