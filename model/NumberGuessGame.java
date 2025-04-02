package model;

import java.util.Random;

import model.strategypattern.HighLowStrategy;
import model.strategypattern.PlayStrategy;

public class NumberGuessGame {
    
    public static final int MAX_KEY = 100;
    
    
    private int key;
    private int guess;
    private boolean showKeyOn;
    private int attempts;
    private PlayStrategy strategy;
    public String progressMessage;

    public NumberGuessGame(){
        start();
        showKeyOn = false; // maybe change it to start();
        setStrategy(new HighLowStrategy(this));
    }

    public void start(){
        key = generateNewKey();
        guess = -1; // this is not being updated
        attempts = 0;
        progressMessage = null;
    }


    private int generateNewKey(){
        Random r = new Random();
        int newKey;
        do {
            newKey = r.nextInt(MAX_KEY + 1);
        } while (newKey == key);
        return newKey;
    }

    public void play(int guess){
       strategy.play(guess);
    }


    public int getAttempts(){
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public PlayStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PlayStrategy strategy){
        this.strategy = strategy;
    }


    public boolean isShowKeyOn(){
        return showKeyOn;
    }

    public void setShowKeyOn(boolean showKeyOn) {
        this.showKeyOn = showKeyOn;
    }


    public int getGuess(){
        return guess;
    }

    public void setGuess(int guess){
        this.guess = guess;
    }

    public int getKey(){
        return key;
    }

    
    @Override
    public String toString(){
        return String.format(
            "key(%d) guess(%d) attempts(%d)", 
            key, guess, attempts
        );

    }
}
