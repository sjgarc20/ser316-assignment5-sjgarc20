package rpg;

public final class Game {

    private static Game INSTANCE;
    
    private static int currentFloor = 0;
    
    private Game() {
    }
    
    public static Game getInstance() {
        if(INSTANCE == null) {
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
