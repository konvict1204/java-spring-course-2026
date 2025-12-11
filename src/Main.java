import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Алексей", 34, Department.IT, List.of(Skill.JAVA, Skill.SPRING, Skill.DOCKER), 300_000),
                new Person("Мария", 28, Department.HR, List.of(Skill.RECRUITING, Skill.JAVA), 150_000),
                new Person("Фридрих", 54, Department.HR, List.of(Skill.RECRUITING, Skill.JAVA), 150_000),
                new Person("Иван", 42, Department.IT, List.of(Skill.JAVA, Skill.KOTLIN, Skill.SPRING), 400_000),
                new Person("Ольга", 31, Department.IT, List.of(Skill.JAVA, Skill.SPRING, Skill.REACT), 350_000),
                new Person("Дмитрий", 25, Department.SALES, List.of(Skill.NEGOTIATION, Skill.JAVA), 200_000),
                new Person("Екатерина", 29, Department.IT, List.of(Skill.JAVA, Skill.PYTHON), 280_000),
                new Person("Сергей", 38, Department.IT, List.of(Skill.JAVA, Skill.SPRING, Skill.KAFKA, Skill.DOCKER), 450_000)
        );


        people.stream()
                .filter(p -> p.age > 30)
                .filter(x-> x.department.equals(Department.IT))
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .forEach(System.out::println);


        people.stream()
                .mapToInt(Person::getSalary)
                .average()
                .ifPresent(System.out::println);

        people.stream()
                .filter(p -> p.getSkills().contains(Skill.SPRING))
                .max(Comparator.comparing(Person::getSalary))
                .ifPresent(System.out::println);

        Map<Department, Long> collect = people.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getDepartment,
                                Collectors.counting()
                        )
                );



        List<Skill> list = people.stream()
                .flatMap(person -> person.getSkills().stream())
                .distinct()
                .sorted(Comparator.comparing(Skill::toString))
                .toList();

        Map<Department, List<Person>> collect2 = people.stream()
                .collect(Collectors.groupingBy(Person::getDepartment));

        Optional<Person> first = people.stream()
                .filter(x -> x.department == Department.IT)
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .skip(1)
                .findFirst();

        long count = people.stream()
                .filter(p -> p.getAge() < 27)
                .filter(x -> x.getSalary() > 250_000)
                .count();
        System.out.println(count>0);



        people.stream()
                .filter(x-> x.skills.contains(Skill.SPRING))
                .map(x -> x.name + "(" + x.salary / 1000 + "k)")
                .reduce((a, b) -> a + "," + b)
                .ifPresent(System.out::println);

        people.stream()
                .filter(x -> x.skills.contains(Skill.JAVA))
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.summingInt(Person::getSalary)))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }


}




