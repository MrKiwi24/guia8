package panels.panel_instance;

import panels.*;

import javax.swing.*;

public class PanelInstance {
    public JFrame routineFrame(){
        JFrame routineFrame = new JFrame ("Add Routine");
        routineFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        routineFrame.getContentPane().add (new RoutinePanel());
        routineFrame.pack();
        routineFrame.setVisible (true);

        return routineFrame;
    }
    public JFrame mainMenuFrame(){
        JFrame mainMenuFrame = new JFrame ("Main Menu");
        mainMenuFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.getContentPane().add (new MainMenuPanel());
        mainMenuFrame.pack();
        mainMenuFrame.setVisible (true);

        return mainMenuFrame;
    }

    public JFrame RoutineMenuFrame(){

        JFrame routineMenuFrame = new JFrame ("Routine Menu");
        routineMenuFrame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        routineMenuFrame.getContentPane().add (new RoutineMenuPanel());
        routineMenuFrame.pack();
        routineMenuFrame.setVisible (true);

        return routineMenuFrame;
    }
}
