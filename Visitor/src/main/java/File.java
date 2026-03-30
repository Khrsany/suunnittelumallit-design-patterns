public class File implements FileSystemElement {
    private final String name;
    private final double size;

    public File(String name, double size) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("File name cannot be null or blank.");
        }
        if (size < 0) {
            throw new IllegalArgumentException("File size cannot be negative.");
        }

        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}