package design_pattern.immutable_pattern;

import java.util.Collection;
import java.util.Collections;

public final class Person<T> {
    private final String name;
    private final int age;
    private final Collection<T> friends;

    public Person(String name, int age, Collection<T> friends) {
        this.name = name;
        this.age = age;
        this.friends = friends;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Collection<T> getFriends() {
        return Collections.unmodifiableCollection(this.friends);
    }

}
