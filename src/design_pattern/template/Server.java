package design_pattern.template;

public class Server extends ComputerTemplate{

	@Override
	public void collectComponents() {
		// TODO Auto-generated method stub
		System.out.println("128Gb ram, Core i9, 1000TB HDD");
		
	}

	@Override
	public void installOs() {
		// TODO Auto-generated method stub
		System.out.println("Installing Ubuntu");
		
	}

	@Override
	public void assembleComponenets() {
		// TODO Auto-generated method stub
		System.out.println("Joining all networking units,.... router");
	}

}
