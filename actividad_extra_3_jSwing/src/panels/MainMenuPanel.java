package panels;

import panels.panel_instance.PanelInstance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenuPanel extends JPanel {
    public static PanelInstance pInstance = new PanelInstance();
    private JButton clientsButton;
    private JButton routinesButton;
    private JLabel clientsLabel;
    private JLabel routinesLabel;

    public MainMenuPanel() {
        //construct components
        clientsButton = new JButton ("Clients");
        routinesButton = new JButton ("Routines");
        clientsLabel = new JLabel ("View, add and delete clients");
        routinesLabel = new JLabel ("View, add and delete routines");

        //adjust size and set layout
        setPreferredSize (new Dimension (384, 178));
        setLayout (null);

        //add components
        add (clientsButton);
        add (routinesButton);
        add (clientsLabel);
        add (routinesLabel);

        //set component bounds (only needed by Absolute Positioning)
        clientsButton.setBounds (30, 20, 100, 100);
        routinesButton.setBounds (245, 20, 100, 100);
        clientsLabel.setBounds (5, 130, 165, 30);
        routinesLabel.setBounds (215, 130, 170, 30);

        //event actions and listeners
        routinesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pInstance.RoutineMenuFrame();
            }
        });
    }
}