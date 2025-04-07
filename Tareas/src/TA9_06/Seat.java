
package TA9_06;

public class Seat {
    private int row;
    private char column;
    private boolean occupied;
    private Spectator spectator;

    public Seat(int row, char column) {
        this.row = row;
        this.column = column;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy(Spectator spectator) {
        this.spectator = spectator;
        this.occupied = true;
    }

    @Override
    public String toString() {
        return row + " " + column + (occupied ? " X (" + spectator.getName() + ")" : " O");
    }
}
