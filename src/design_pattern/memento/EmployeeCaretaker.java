package design_pattern.memento;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCaretaker {
	
	private List<EmployeeMemento> mementos = new ArrayList<>();
	
	public void addMemento(EmployeeMemento employeeMemento){
		mementos.add(employeeMemento);
	}
	
	 public EmployeeMemento getMemento(int index) {
	        return mementos.get(index);
	    }

}
