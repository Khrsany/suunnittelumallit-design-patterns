// Builder-rajapinta kertoo mitä osia rakennetaan
public interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    Computer getComputer();
}