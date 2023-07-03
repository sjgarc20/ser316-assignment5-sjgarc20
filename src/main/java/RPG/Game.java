package rpg;

public enum Game {

    INSTANCE(0);
    
    private int currentFloor;
    
    private Game(int floor) {
        this.setCurrentFloor(floor);
    }
    
    public Game getInstance() {
        return INSTANCE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    
    
}
