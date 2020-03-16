package se.comhem.test.montyhall;

public class SimulationResult {
    private int iterations;
    private int wins;
    private boolean changeDoor;

    public SimulationResult(int iterations, int wins, boolean changeDoor) {
        this.iterations = iterations;
        this.wins = wins;
        this.changeDoor = changeDoor;
    }

    public int getIterations() {
        return iterations;
    }

    public int getWins() {
        return wins;
    }

    public boolean isChangeDoor() {
        return changeDoor;
    }
}
