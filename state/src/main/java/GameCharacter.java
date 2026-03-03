public class GameCharacter {
    private final String name;
    private int experiencePoints;
    private int healthPoints;

    private CharacterState state;

    public static final int XP_TO_INTERMEDIATE = 100;
    public static final int XP_TO_EXPERT = 250;
    public static final int XP_TO_MASTER = 500;

    public static final int MAX_HP = 100;
    public static final int MIN_HP = 0;

    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.healthPoints = 50;
        this.state = new NoviceState();
    }

    public String getName() { return name; }
    public int getExperiencePoints() { return experiencePoints; }
    public int getHealthPoints() { return healthPoints; }
    public CharacterState getState() { return state; }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public void addXp(int amount) {
        if (amount < 0) return;
        experiencePoints += amount;
        checkLevelUp();
    }

    public void addHp(int amount) {
        healthPoints += amount;
        if (healthPoints > MAX_HP) healthPoints = MAX_HP;
        if (healthPoints < MIN_HP) healthPoints = MIN_HP;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public boolean isGameFinished() {
        return state instanceof MasterState;
    }

    public void train() { state.train(this); }
    public void meditate() { state.meditate(this); }
    public void fight() { state.fight(this); }

    public String statusText() {
        return """
               ----------------------------
               Name: %s
               Level: %s
               XP: %d
               HP: %d/%d
               ----------------------------
               """.formatted(name, state.getLevelName(), experiencePoints, healthPoints, MAX_HP);
    }

    private void checkLevelUp() {
        if (experiencePoints >= XP_TO_MASTER && !(state instanceof MasterState)) {
            setState(new MasterState());
            return;
        }
        if (experiencePoints >= XP_TO_EXPERT && state instanceof IntermediateState) {
            setState(new ExpertState());
            return;
        }
        if (experiencePoints >= XP_TO_INTERMEDIATE && state instanceof NoviceState) {
            setState(new IntermediateState());
        }
    }
}