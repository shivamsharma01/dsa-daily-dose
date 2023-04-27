package design_pattern.template;

public abstract class ComputerTemplate {
	
	public final void buildComputer() { // flow already defined by parent class.
		collectComponents();
		assembleComponenets();
		installOs();
		startComputer();
		System.out.println("Computer is ready!");
	}
	
	private void startComputer() {
		System.out.println("System is booting.");
	}
	
	public abstract void  collectComponents(); //template methods
	
	public abstract void installOs(); //template methods

	
	public abstract void assembleComponenets(); //template methods

	
	
}
