import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> elements;

    public Directory(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Directory name cannot be null or blank.");
        }

        this.name = name;
        this.elements = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void addElement(FileSystemElement element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null.");
        }
        elements.add(element);
    }

    public List<FileSystemElement> getElements() {
        return Collections.unmodifiableList(elements);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}