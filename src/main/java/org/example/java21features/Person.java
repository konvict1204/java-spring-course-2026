package main.java.org.example.java21features;

public record Person(String name, int age, Department department, int salary) {

    public Person {
        if (age < 18 || age > 100) {
            throw new IllegalArgumentException();
        }
        if (salary < 0) {
            throw new IllegalArgumentException();
        }
    }
}
