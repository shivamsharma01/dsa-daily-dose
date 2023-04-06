package design_pattern.decorator.starbucks;

public class Espresso implements Beverage{

    private final String beverageName = "Espresso";
    private final int price = 10;
    @Override
    public String getBeverageName() {
        return beverageName;
    }

    @Override
    public int getCoffeePrice() {
        return price;
    }
}
