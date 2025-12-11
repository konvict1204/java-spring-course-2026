package main.java.org.example.java21features;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModernJavaTasks {
    public static void main(String[] args) {
        Person person = new Person("Aslan",18,Department.IT, 10_000);
        System.out.println(getJson(person));

    }
    public static String describeWorker(Worker worker) {
        switch (worker){
            case Developer c -> {
                int years = LocalDate.now().getYear() - c.hireDate().getYear();
                if(years > 5){
                    return "Senior dev";
                }
                if(years > 2){
                    return "Middle dev";
                } else
                    return "Junior dev";

            }
            case Manager c -> {
                return "Team Lead";
            }
            case Intern c -> {
                return "Стажер";
            }

        }


    }

    public static <T extends Number & Comparable<T>> Optional<T> findMax(List<T> list){
        return list.stream().max(Comparator.comparing(Number::intValue));
    }

    public static String getJson(Person person) {
        return """
                {name: $person.name()!, salary: &person.salary()!
                """;
    }
    public static List<String> opt (List<Optional<Person>> list){
        return list.stream()
                .filter(Optional::isPresent)
                .filter(x-> x.get().salary() > 300_000)
                .map(x -> x.get().name())
                 .collect(Collectors.toCollection(ArrayList::new));
    }


}
