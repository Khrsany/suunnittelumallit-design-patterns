// Computer = valmis tuote
public class Computer {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void displayConfiguration() {
        System.out.println("Tietokoneen kokoonpano:");
        System.out.println("Prosessori: " + processor);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Tallennustila: " + hardDrive);
        System.out.println("Näytönohjain: " + graphicsCard);
        System.out.println("Käyttöjärjestelmä: " + operatingSystem);
        System.out.println();
    }
}