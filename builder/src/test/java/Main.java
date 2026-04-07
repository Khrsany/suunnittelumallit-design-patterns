public class Main {
    public static void main(String[] args) {

        // Rakennetaan ensin pelitietokone
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(gamingBuilder);

        director1.constructComputer();
        Computer gamingComputer = gamingBuilder.getComputer();

        System.out.println("Pelitietokone:");
        gamingComputer.displayConfiguration();

        // Rakennetaan sitten toimistotietokone
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(officeBuilder);

        director2.constructComputer();
        Computer officeComputer = officeBuilder.getComputer();

        System.out.println("Toimistotietokone:");
        officeComputer.displayConfiguration();
    }
}