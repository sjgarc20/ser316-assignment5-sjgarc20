package rpg;

public enum Game {

    INSTANCE(0);
    
    private int currentFloor;
    
    private Game(int floor) {
        this.currentFloor = 0;
    }
    
    public Game getInstance() {
        return INSTANCE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void advanceFloor() {
        this.currentFloor = this.currentFloor + 1;
    }
    
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    
    
}
