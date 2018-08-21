package jmines;

import javafx.scene.layout.BorderPane;

public class GameWindow extends BorderPane {

    private GameGrid gameGrid;

    public GameWindow() {
        gameGrid = new GameGrid(8);

        setCenter(gameGrid);
    }
}
