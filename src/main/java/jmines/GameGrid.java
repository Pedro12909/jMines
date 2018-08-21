package jmines;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.util.Random;

public class GameGrid extends GridPane {

    private int windowSize;

    private static final int BOMBS = 10;

    public GameGrid(int windowSize) {
        if (windowSize < 0) {
            throw new IllegalArgumentException("Window Size must be positive - given: "
                    + windowSize);
        }

        this.windowSize = windowSize;

        setProperties();

        createGrid();

        placeBombs();
    }

    private void setProperties() {
        setPadding(new Insets(50));
        setAlignment(Pos.CENTER);
        setHgap(0);
        setVgap(0);
    }

    private void createGrid() {
        // Set Constraints
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100.0 / windowSize);
        ColumnConstraints colConstraints = new ColumnConstraints();
        colConstraints.setPercentWidth(100.0 / windowSize);

        // Defines size of all columns and rows in the grid
        // This forces all cells to be the same size
        for (int i = 0; i < windowSize; i++) {
            getRowConstraints().add(rowConstraints);
            getColumnConstraints().add(colConstraints);
        }

        for (int i = 0; i < windowSize; i++) {
            for (int j = 0; j < windowSize; j++) {
                Cell cell = new Cell(i, j);

                // Set Action Listener for cell
                cell.setOnAction(onAction -> {

                });

                add(cell, i, j);

                GridPane.setHalignment(cell, HPos.CENTER);
                GridPane.setValignment(cell, VPos.CENTER);
            }
        }
    }

    private void placeBombs() {
        int placedBombs = 0;

        Random randomGen = new Random(windowSize);

        while (placedBombs < BOMBS) {
            final int nextI = randomGen.nextInt();
            final int nextJ = randomGen.nextInt();

            Cell nextCell = getCell(nextI, nextJ);

            if (nextCell.isBomb()) continue;

            nextCell.makeBomb();

            placedBombs++;
        }
    }

    private Cell getCell(int i, int j) {
        for (Node node:
             getChildren()) {
            if (getColumnIndex(node) == i
                    && getRowIndex(node) == j) {
                return (Cell)node;
            }
        }

        return null;
    }
}
