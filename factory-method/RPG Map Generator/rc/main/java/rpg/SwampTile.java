package rpg;

public class SwampTile implements Tile {
    @Override
    public String getType() {
        return "swamp";
    }
    @Override
    public char getCharacter(){
        return 'S';
    }

    @Override
    public void action() {

    }
}
