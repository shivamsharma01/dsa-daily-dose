package design_pattern.template;

public class TemplatePatternDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Buying laptop
        ComputerTemplate laptop = new Laptop();
        laptop.buildComputer();

        System.out.println("----------------------------------------");

        //BuyingServer
        ComputerTemplate server = new Server();
        server.buildComputer();

    }

}
