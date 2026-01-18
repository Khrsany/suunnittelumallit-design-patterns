package rpg;

public class BuildingTile implements Tile {
    @Override
    public String getType() {
        return "building";
    }

    @Override
    public char getCharacter() {
        return 'B';
    }
    @Override
    public void action() {}
}
