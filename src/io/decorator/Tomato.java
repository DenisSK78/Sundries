package io.decorator;

public class Tomato implements Ingredient{
    //ConcreteComponent (finish)
    @Override
    public Integer getCost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return " tomato.";
    }
}
