package composite;
import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {
    private String name;
    private List<OrganizationComponent> children;

    public Department(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    @Override
    public double getSalary() {
        double total = 0;
        for (OrganizationComponent child : children) {
            total += child.getSalary();
        }
        return total;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<department>");
        sb.append("<name>").append(name).append("</name>");
        sb.append("<children>");
        for (OrganizationComponent child : children) {
            sb.append(child.toXML());
        }
        sb.append("</children>");
        sb.append("</department>");
        return sb.toString();
    }
}
