package design_pattern.memento;

public class MementoDemo {

	public static void main(String[] args) {
		
		
		//Creating employee Object
		EmployeeOriginator employee = new EmployeeOriginator("Vishal Deswal",23, 1000);

		EmployeeCaretaker caretaker = new EmployeeCaretaker();
		
		//Saving current object state
		caretaker.addMemento(employee.save());
		
		//modify the employee's properties
		employee.setName("Shivam sharma");
		employee.setAge(29);
		employee.setSalary(2000);
		
		
		//save the employee state again and add it to caretaker
		caretaker.addMemento(employee.save());
		
		System.out.println("Before restoring:");
		System.out.println(employee);
		
		
		
		//retore the employee's previuos state
		employee.restore(caretaker.getMemento(0));
		System.out.println("After restoring");
		System.out.println(employee);

	}

}
