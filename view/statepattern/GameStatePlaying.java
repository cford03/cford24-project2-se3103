package view.statepattern;

import java.awt.Font;
import java.awt.Graphics2D;

import controller.App;
import model.NumberGuessGame;
import view.AppWindow;

public class GameStatePlaying implements GameState {

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStateDone());
    }

    @Override
    public void updateWindow() {
        App.win.newGameButton.setEnabled(false);
        App.win.numberField.setEnabled(true);
        App.win.highLowButton.setEnabled(false);
        App.win.closerAwayButton.setEnabled(false);
        App.win.showKeyButton.setEnabled(true);
        App.win.canvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD,16));
        NumberGuessGame game = App.game;

        if(game.isShowKeyOn()){
            var keyString = String.format("(Key. %d)", game.getKey());
            g2.drawString(keyString,50,100);
        }

        String promptString;
        if(App.game.getGuess() >= 0){
            promptString = String.format("Your Guess: %d (Attempts: %d)", 
            App.game.getGuess(), App.game.getAttempts()); // something is wrong here
        } else {
            promptString = "Enter your guess";
        }
        g2.drawString(promptString, 50, 150);

        if(game.progressMessage != null){
            g2.drawString(game.progressMessage, 100, 200);
        }
    }

}
