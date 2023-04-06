package design_pattern.decorator.starbucks;


public class CoffeeMachine {

    public static void main(String[] args) {
        Beverage beverage = new Cappucino();
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getCoffeePrice());

        beverage = new Milk(beverage);
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getCoffeePrice());

        beverage = new Milk(beverage);
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getCoffeePrice());
    }


}
