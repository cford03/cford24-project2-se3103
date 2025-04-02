package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.App;
import controller.NewGameButtonListener;
import controller.NumberEnterListener;
import controller.ShowKeyButtonListener;
import controller.StrategySelectionListener;
import model.strategypattern.CloserAwayStrategy;
import model.strategypattern.HighLowStrategy;
import view.statepattern.GameState;
import view.statepattern.GameStateInit;

public class AppWindow extends JFrame {
    
    public static final String highLowAction = "High/Low";
    public static final String closerAwayAction = "Closer/Away";

    public AppCanvas canvas;
    public JRadioButton highLowButton;
    public JRadioButton closerAwayButton;

    public JCheckBox showKeyButton;
    public JButton newGameButton;
    public JButton exitButton;

    private GameState state = new GameStateInit();


    public JTextField numberField;

    public void init(){
        var cp = getContentPane();
        canvas = new AppCanvas();
            cp.add(canvas,BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 1));
        cp.add(southPanel,BorderLayout.SOUTH);

        JPanel numberPanel = new JPanel();
        southPanel.add(numberPanel);
        numberPanel.setBorder(new TitledBorder("your guess"));
        numberPanel.add(new JLabel("Enter(0 ~ 100)"));
        numberField = new JTextField(10);
        numberPanel.add(numberField);
        numberField.addActionListener(new NumberEnterListener());

        JPanel strategyPanel = new JPanel();
        strategyPanel.setBorder(new TitledBorder("Select strategy"));
        highLowButton = new JRadioButton(highLowAction, 
            App.game.getStrategy() instanceof HighLowStrategy
        );
        closerAwayButton = new JRadioButton(closerAwayAction,
            App.game.getStrategy() instanceof CloserAwayStrategy
        );
        strategyPanel.add(highLowButton);
        strategyPanel.add(closerAwayButton);
        southPanel.add(strategyPanel);
        StrategySelectionListener strategySelectionListener = new StrategySelectionListener();
        highLowButton.addActionListener(strategySelectionListener);
        closerAwayButton.addActionListener(strategySelectionListener);


        ButtonGroup strategyGroup = new ButtonGroup();
        strategyGroup.add(highLowButton);
        strategyGroup.add(closerAwayButton);


        JPanel actionPanel = new JPanel();
        southPanel.add(actionPanel);
        showKeyButton = new JCheckBox("show key");
        showKeyButton.addItemListener(new ShowKeyButtonListener());
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new NewGameButtonListener());
        exitButton = new JButton("Exit");
        //exitButton.addActionListener(new ExitButtonListener());
        // exitButton.addActionListener( (e) -> {
        //     System.exit(0);
        // });
        exitButton.addActionListener( e -> System.exit(0));

        actionPanel.add(showKeyButton);
        actionPanel.add(newGameButton);
        actionPanel.add(exitButton);



        updateWindow();
        
        
    }

    public void goNextState(){
        state.goNext(this);
    }

    public GameState getGameState(){
        return state;
    }

    public void setGameState(GameState state){
        this.state = state;
    }

    public void updateWindow(){
        state.updateWindow();
    }
    
}
