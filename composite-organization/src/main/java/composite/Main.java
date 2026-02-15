package composite;

public class Main {
    public static void main(String[] args) {
        Department headOffice = new Department("Head Office");
        Department salesDepartment = new Department("Sales Department");
        Department itDepartment = new Department("IT Department");

        Employee alice = new Employee("Alice", 50000);
        Employee bob = new Employee("Bob", 60000);
        Employee charlie = new Employee("Charlie", 55000);

        headOffice.add(salesDepartment);
        headOffice.add(itDepartment);

        salesDepartment.add(alice);
        salesDepartment.add(bob);

        itDepartment.add(charlie);

        System.out.println("Total Salary: " + headOffice.getSalary());
        System.out.println("Organization Structure in XML:");
        System.out.println(headOffice.toXML());
    }
}
