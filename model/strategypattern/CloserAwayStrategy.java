package model.strategypattern;

import model.NumberGuessGame;

public class CloserAwayStrategy implements PlayStrategy {
    
    private NumberGuessGame game;

    public CloserAwayStrategy(NumberGuessGame game) {
        this.game = game;
    }

    @Override
    public void play(int guess) {
        int previousGuess = game.getGuess(); //holds the previous guess
        game.setGuess(guess);
        game.setAttempts(game.getAttempts() + 1);
        int prevDiff = Math.abs(game.getKey() - previousGuess); 
        int newDiff = Math.abs(game.getKey() - game.getGuess());
        if(newDiff - prevDiff < 0){
            game.progressMessage = "Getting closer";

        } else {
            game.progressMessage = "Not getting closer";
        }
    }

    
    
}
