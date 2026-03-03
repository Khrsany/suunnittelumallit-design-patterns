public class IntermediateState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public void train(GameCharacter character) {
        character.addXp(25);
        System.out.println("You trained harder. +25 XP");
        System.out.println("(Need " + GameCharacter.XP_TO_EXPERT + " XP for Expert)");
    }

    @Override
    public void meditate(GameCharacter character) {
        character.addHp(15);
        System.out.println("You meditated. +15 HP");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You cannot fight at Intermediate level. Train more.");
    }

    @Override
    public String availableActionsText() {
        return "Available actions: 1) Train  2) Meditate";
    }
}