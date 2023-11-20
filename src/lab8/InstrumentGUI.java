package lab8;

import lab8.instrument.Instrument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstrumentGUI {
    private JFrame frame;
    private JPanel namePanel;
    private JPanel weightPanel;
    private JPanel tminPanel;
    private JPanel tmaxPanel;

    private static final String NAME_LABEL_TEXT = "The name of the instrument:";
    private static final String WEIGHT_LABEL_TEXT = "The weight of the instrument:";
    private static final String TMIN_LABEL_TEXT = "The minimum temperature of the instrument:";
    private static final String TMAX_LABEL_TEXT = "The maximum temperature of the instrument:";

    private Instrument currentInstrument;

    public InstrumentGUI() {
        setupGUI();
        setupButtonActions();

        frame.pack();
        frame.setVisible(true);
    }

    private void setupGUI() {
        frame = new JFrame("Instrument GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));

        namePanel = createStyledLabelAndTextField(NAME_LABEL_TEXT);
        weightPanel = createStyledLabelAndTextField(WEIGHT_LABEL_TEXT);
        tminPanel = createStyledLabelAndTextField(TMIN_LABEL_TEXT);
        tmaxPanel = createStyledLabelAndTextField(TMAX_LABEL_TEXT);

        frame.add(namePanel);
        frame.add(weightPanel);
        frame.add(tminPanel);
        frame.add(tmaxPanel);

        JButton blueButton = createBlueButton("Create instrument");
        frame.add(blueButton);
    }

    private void setupButtonActions() {
        JButton createButton = (JButton) frame.getContentPane().getComponent(4);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInstrument();
            }
        });
    }

    private void createInstrument() {
        try {
            String name = ((JTextField) namePanel.getComponent(1)).getText().trim();
            String weightText = ((JTextField) weightPanel.getComponent(1)).getText().trim();
            String tminText = ((JTextField) tminPanel.getComponent(1)).getText().trim();
            String tmaxText = ((JTextField) tmaxPanel.getComponent(1)).getText().trim();


            if (name.isEmpty() || weightText.isEmpty() || tminText.isEmpty() || tmaxText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            int weight = Integer.parseInt(weightText);
            int tmin = Integer.parseInt(tminText);
            int tmax = Integer.parseInt(tmaxText);


            if (tmin > tmax) {
                JOptionPane.showMessageDialog(frame, "Min temperature should be less than or equal to max temperature", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            currentInstrument = new Instrument(name, weight, tmin, tmax);

            displayInstrumentInfo();

            clearTextFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for weight, min temperature, and max temperature", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayInstrumentInfo() {
        JFrame infoFrame = new JFrame("Instrument info");
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel[] labels = {
                new JLabel("Name: " + currentInstrument.getName()),
                new JLabel("Weight: " + currentInstrument.getWeight()),
                new JLabel("Min Temperature: " + currentInstrument.getTmin()),
                new JLabel("Max Temperature: " + currentInstrument.getTmax()),
                new JLabel("Is open: " + currentInstrument.isOpen())
        };


        JButton openButton = createBlueButton("Open instrument");
        JButton closeButton = createBlueButton("Close instrument");

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentInstrument != null) {
                    if (e.getSource() == openButton) {
                        currentInstrument.open();
                    } else if (e.getSource() == closeButton) {
                        currentInstrument.close();
                    }
                    updateIsOpenLabel(labels[4]);
                } else {
                    JOptionPane.showMessageDialog(infoFrame, "No instrument created yet!");
                }
            }
        };

        openButton.addActionListener(buttonListener);
        closeButton.addActionListener(buttonListener);


        infoFrame.setLayout(new GridLayout(7, 1));
        for (JLabel label : labels) {
            label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            infoFrame.add(label);
        }
        infoFrame.add(openButton);
        infoFrame.add(closeButton);

        infoFrame.pack();

        infoFrame.setSize(300, 350);
        infoFrame.setResizable(false);
        infoFrame.setVisible(true);
    }

    private void updateIsOpenLabel(JLabel isOpenLabel) {
        isOpenLabel.setText("Is open: " + currentInstrument.isOpen());
    }

    private JPanel createStyledLabelAndTextField(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textField.setPreferredSize(new Dimension(200, 20));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.EAST);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        return panel;
    }

    private JButton createBlueButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(68, 138, 255));
        button.setForeground(Color.WHITE);

        return button;
    }

    private void clearTextFields() {
        ((JTextField) namePanel.getComponent(1)).setText("");
        ((JTextField) weightPanel.getComponent(1)).setText("");
        ((JTextField) tminPanel.getComponent(1)).setText("");
        ((JTextField) tmaxPanel.getComponent(1)).setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InstrumentGUI::new);
    }
}