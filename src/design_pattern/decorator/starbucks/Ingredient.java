package design_pattern.decorator.starbucks;

public abstract class Ingredient implements Beverage{
   private final Beverage beverage;
    public Ingredient(Beverage beverage){
        this.beverage = beverage;
        }
    public String getBeverageName() {
        return beverage.getBeverageName() ;
    }
    public int getCoffeePrice() {
        return beverage.getCoffeePrice() ;
    }

}
