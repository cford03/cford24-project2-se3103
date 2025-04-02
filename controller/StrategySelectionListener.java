package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.strategypattern.CloserAwayStrategy;
import model.strategypattern.HighLowStrategy;
import view.AppWindow;

public class StrategySelectionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch(action){
            case AppWindow.highLowAction:
                App.game.setStrategy(new HighLowStrategy(App.game)); //changed
                break;
            case AppWindow.closerAwayAction:
                App.game.setStrategy(new CloserAwayStrategy(App.game)); // changed
                break;
        }
    }
    
    
}
