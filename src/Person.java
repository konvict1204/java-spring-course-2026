import java.util.List;

public class Person {
    String name;
    int age;
    Department department;
    List<Skill> skills;
    int salary;

    public Person(String name, int age, Department department, List<Skill> skills, int salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.skills = skills;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", skills=" + skills +
                ", salary=" + salary +
                '}';
    }
}
