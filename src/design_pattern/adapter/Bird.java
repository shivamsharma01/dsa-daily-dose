package design_pattern.adapter;

interface Bird {
    // birds implement Bird interface that allows
    // them to fly and make sounds adaptee interface
    public void fly();

    public void makeSound();
}