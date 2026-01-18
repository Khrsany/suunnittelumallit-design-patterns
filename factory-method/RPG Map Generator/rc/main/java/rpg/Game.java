package rpg;

public class Game {

    public static void main(String[] args) {
        Map map = createMap();
        map.display();
    }

    private static Map createMap() {
        return new WildernessMap();
    }
}
