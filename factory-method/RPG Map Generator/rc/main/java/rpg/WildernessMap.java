package rpg;

public class WildernessMap extends Map{

    @Override
    protected Tile createTile() {
        int random = (int)(Math.random()*3);
        if (random == 0) {
            return new SwampTile();
        } else if (random == 1) {
            return new WaterTile();
        } else {
            return new ForestTile();
        }
    }
}