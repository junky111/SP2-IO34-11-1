package SP.Lab1;


public class Rows {

    private String name;
    private UnionType salary;

    public Rows(String name, UnionType salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnionType getUnion() {
        return salary;
    }

    public void setUnion(UnionType salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Salary: " + salary.getSalary();
    }
}
