public class NoviceState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public void train(GameCharacter character) {
        character.addXp(20);
        System.out.println("You trained. +20 XP");
        System.out.println("(Need " + GameCharacter.XP_TO_INTERMEDIATE + " XP for Intermediate)");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You cannot meditate at Novice level. Train first.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You cannot fight at Novice level. Train first.");
    }

    @Override
    public String availableActionsText() {
        return "Available actions: 1) Train";
    }
}