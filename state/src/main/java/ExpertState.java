public class ExpertState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Expert";
    }

    @Override
    public void train(GameCharacter character) {
        character.addXp(30);
        System.out.println("You trained like a machine. +30 XP");
        System.out.println("(Need " + GameCharacter.XP_TO_MASTER + " XP for Master)");
    }

    @Override
    public void meditate(GameCharacter character) {
        character.addHp(20);
        System.out.println("You meditated deeply. +20 HP");
    }

    @Override
    public void fight(GameCharacter character) {
        if (character.getHealthPoints() <= 10) {
            System.out.println("Too low HP to fight safely. Meditate first.");
            return;
        }
        character.addHp(-10);
        character.addXp(40);
        System.out.println("You fought bravely. -10 HP, +40 XP");
    }

    @Override
    public String availableActionsText() {
        return "Available actions: 1) Train  2) Meditate  3) Fight";
    }
}