package main.java.org.example.java21features;

import java.time.LocalDate;

public record Manager(LocalDate hireDate) implements Worker{
}
