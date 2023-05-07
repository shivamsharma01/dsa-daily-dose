package design_pattern.template;

public class Laptop extends ComputerTemplate {

    @Override
    public void collectComponents() {
        System.out.println("4Gb ram, Core i5, 512GB HDD");

    }

    @Override
    public void installOs() {
        // TODO Auto-generated method stub
        System.out.println("Installing windows");
    }

    @Override
    public void assembleComponents() {
        // TODO Auto-generated method stub
        System.out.println("Joining all units,keyboard.. mouse...");

    }

}
