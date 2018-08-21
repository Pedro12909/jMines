package jmines;

import javafx.scene.control.Button;

public class Cell extends Button {

    private boolean isBomb = false;

    private int xPos;

    private int yPos;

    public Cell(int xPos, int yPos) {
        if (xPos < 0 || yPos < 0) {
            throw new IllegalArgumentException("Invalid Position given to Cell: ("
                    + xPos + ", " + yPos + ")");
        }

        this.isBomb = isBomb;
        this.xPos = xPos;
        this.yPos = yPos;

        setCellProperties();
    }

    private void setCellProperties() {
        setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void makeBomb() {
        isBomb = true;
    }
}
