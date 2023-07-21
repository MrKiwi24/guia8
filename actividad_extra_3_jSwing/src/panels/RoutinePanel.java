package panels;

import java.awt.*;
import javax.swing.*;

public class RoutinePanel extends JPanel {
    private JLabel routineLabel;
    private JLabel durationLabel;
    private JSlider difficultySlider;
    private JLabel difficultyLabel;
    private JLabel descriptionLabel;
    private JButton confirmRoutineButton;
    private JTextArea descriptionTA;
    private JTextField durationTF;
    private JTextField routineNameTF;
    private JButton cancelButton;

    public RoutinePanel() {
        //construct components
        routineLabel = new JLabel ("Routine Name");
        durationLabel = new JLabel ("Duration");
        difficultySlider = new JSlider (0, 10);
        difficultyLabel = new JLabel ("Difficulty Level");
        descriptionLabel = new JLabel ("Description");
        confirmRoutineButton = new JButton ("Create Routine");
        descriptionTA = new JTextArea (5, 5);
        durationTF = new JTextField (5);
        routineNameTF = new JTextField (5);
        cancelButton = new JButton ("Cancel");

        //set components properties
        difficultySlider.setOrientation (JSlider.HORIZONTAL);
        difficultySlider.setMinorTickSpacing (1);
        difficultySlider.setMajorTickSpacing (10);
        difficultySlider.setPaintTicks (true);
        difficultySlider.setPaintLabels (true);

        //adjust size and set layout
        setPreferredSize (new Dimension (368, 315));
        setLayout (null);

        //add components
        add (routineLabel);
        add (durationLabel);
        add (difficultySlider);
        add (difficultyLabel);
        add (descriptionLabel);
        add (confirmRoutineButton);
        add (descriptionTA);
        add (durationTF);
        add (routineNameTF);
        add (cancelButton);

        //set component bounds (only needed by Absolute Positioning)
        routineLabel.setBounds (25, 20, 100, 25);
        durationLabel.setBounds (25, 65, 100, 25);
        difficultySlider.setBounds (130, 105, 225, 40);
        difficultyLabel.setBounds (25, 110, 100, 25);
        descriptionLabel.setBounds (25, 165, 100, 25);
        confirmRoutineButton.setBounds (200, 265, 155, 35);
        descriptionTA.setBounds (135, 160, 220, 95);
        durationTF.setBounds (135, 65, 215, 25);
        routineNameTF.setBounds (135, 20, 215, 25);
        cancelButton.setBounds (5, 285, 80, 25);
    }
}