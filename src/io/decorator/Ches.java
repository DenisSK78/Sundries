package io.decorator;

public class Ches extends PizzaIngredient {
    //Concrete decorator
    public Ches(Ingredient ingredient) {
        super(ingredient);
    }

    @Override
    public Integer getCost() {
        return super.getCost()+2;
    }

    @Override
    public String getDescription() {
        return " ches," + super.getDescription();
    }
}
