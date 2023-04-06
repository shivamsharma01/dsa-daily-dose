package design_pattern.decorator.starbucks;

public class Milk extends Ingredient {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getBeverageName() {
        return super.getBeverageName() + "with Milk";
    }

    @Override
    public int getCoffeePrice() {
        return super.getCoffeePrice() + 2;
    }
}
