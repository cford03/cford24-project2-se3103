package view.statepattern;

import java.awt.Font;
import java.awt.Graphics2D;

import controller.App;
import view.AppWindow;

public class GameStateDone implements GameState {

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void updateWindow() {
        App.win.newGameButton.setEnabled(true);
        App.win.numberField.setEnabled(false);
        App.win.highLowButton.setEnabled(true);
        App.win.closerAwayButton.setEnabled(true);
        App.win.showKeyButton.setEnabled(true);
        App.win.canvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        var message1 = String.format("%d is correct(attempts = %d)",
        App.game.getKey(), App.game.getAttempts()
        );
        var message2 = "Press <New Game> to play again!";
        g2.drawString(message1,50, 100);
        g2.drawString(message2,50, 150);
    }

}
