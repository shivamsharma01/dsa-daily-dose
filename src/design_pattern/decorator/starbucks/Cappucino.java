package design_pattern.decorator.starbucks;

public class Cappucino implements Beverage {

    private final String beverageName = "Cappucino";
    private final int price = 15;

    @Override
    public String getBeverageName() {
        return beverageName;
    }

    @Override
    public int getCoffeePrice() {
        return price;
    }
}
