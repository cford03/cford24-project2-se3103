package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewGameButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        App.game.start();
        App.win.goNextState(); // changed
        App.win.updateWindow();
    }
    
}
