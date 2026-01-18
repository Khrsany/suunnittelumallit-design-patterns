package rpg;

public class CityMap extends Map {

    @Override
    protected Tile createTile() {
        int random = (int) (Math.random() * 3);

        if (random == 0) {
            return new RoadTile();
        } else if (random == 1) {
            return new ForestTile();
        } else {
            return new BuildingTile();
        }
    }
}
