public class MasterState implements CharacterState {

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public void train(GameCharacter character) {
        System.out.println("You are already a Master. The journey is complete.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You are already a Master. The journey is complete.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are already a Master. The journey is complete.");
    }

    @Override
    public String availableActionsText() {
        return "No actions. Game ends at Master level.";
    }
}