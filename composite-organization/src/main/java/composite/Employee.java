package composite;

public class Employee implements OrganizationComponent {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    @Override
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("cant containe childrens.");
    }

    @Override
    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("cant containe childrens.");
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toXML() {
        return "<employee>" +
                "<name>" + name + "</name>" +
                "<salary>" + salary + "</salary>" +
                "</employee>";
    }
}
