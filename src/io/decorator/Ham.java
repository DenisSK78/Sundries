package io.decorator;

public class Ham extends PizzaIngredient {
    //Concrete decorator
    public Ham(Ingredient ingredient) {
        super(ingredient);
    }

    @Override
    public Integer getCost() {
        return super.getCost() + 3;
    }

    @Override
    public String getDescription() {
        return " ham,"+ super.getDescription();
    }
}
