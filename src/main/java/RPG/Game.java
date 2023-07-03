package rpg;

/**
 * Singleton of Game class, handles important global data
 * of the game for use in the Logic class.
 * @author Sam
 *
 */
public final class Game {

    private static Game INSTANCE;
    
    private static int currentFloor = 0;
    
    private Game() {
    }
    
    /**
     * Creates an instance of Game if it does not already exist.
     * @return reference to instance of Game
     */
    public static Game getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Game();
        }
        return INSTANCE;
    }

    public static int getCurrentFloor() {
        return currentFloor;
    }

    public static void advanceFloor() {
        Game.currentFloor = Game.currentFloor + 1;
    }
    
    public static void setCurrentFloor(int currentFloor) {
        Game.currentFloor = currentFloor;
    }
}
