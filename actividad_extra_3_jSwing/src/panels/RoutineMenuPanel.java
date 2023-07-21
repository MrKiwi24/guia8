package panels;

import panels.panel_instance.PanelInstance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RoutineMenuPanel extends JPanel {
    private JButton newRoutineButton;
    private JButton listRoutinesButton;
    private JButton updateRoutineButton;
    private JButton deleteRoutineButton;
    private JButton backButton;
    public static PanelInstance pInstance = new PanelInstance();

    public RoutineMenuPanel() {
        //construct components
        newRoutineButton = new JButton ("Create new Routine");
        listRoutinesButton = new JButton ("Show all Routines");
        updateRoutineButton = new JButton ("Update a Routine's info");
        deleteRoutineButton = new JButton ("Delete a Routine");
        backButton = new JButton ("<= Back");

        //adjust size and set layout
        setPreferredSize (new Dimension (220, 300));
        setLayout (null);

        //add components
        add (newRoutineButton);
        add (listRoutinesButton);
        add (updateRoutineButton);
        add (deleteRoutineButton);
        add (backButton);

        //set component bounds (only needed by Absolute Positioning)
        newRoutineButton.setBounds (25, 15, 170, 35);
        listRoutinesButton.setBounds (25, 55, 170, 35);
        updateRoutineButton.setBounds (25, 95, 170, 40);
        deleteRoutineButton.setBounds (25, 140, 170, 35);
        backButton.setBounds (60, 230, 100, 25);

        //Action listeners and actions
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pInstance.mainMenuFrame();
                System.exit(0);
            }
        });
    }

}