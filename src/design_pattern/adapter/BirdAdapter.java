package design_pattern.adapter;

class BirdAdapter implements ToyDuck {
    // We need to implement the interface client expects to use.
    Bird bird;

    public BirdAdapter(Bird bird) {
        // we need reference to the object we are adapting
        this.bird = bird;
    }

    public void squeak() {
        bird.makeSound();
    }
}
