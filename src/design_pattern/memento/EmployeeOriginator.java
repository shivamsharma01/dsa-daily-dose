package design_pattern.memento;

public class EmployeeOriginator {
    private String name;
    private int age;
    private double salary;

    public EmployeeOriginator(String name, int age, double salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public EmployeeMemento save() {
        return new EmployeeMemento(this.name, this.age, this.salary);
    }

    @Override
    public String toString() {
        return "EmployeeOriginator [name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }

    public void restore(EmployeeMemento employeeMemento) {
        this.name = employeeMemento.getName();
        this.age = employeeMemento.getAge();
        this.salary = employeeMemento.getSalary();
    }

}
