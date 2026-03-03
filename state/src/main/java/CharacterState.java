public interface CharacterState {
    String getLevelName();

    void train(GameCharacter character);
    void meditate(GameCharacter character);
    void fight(GameCharacter character);

    String availableActionsText();
}