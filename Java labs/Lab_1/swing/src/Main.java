import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

/**
 * Swing application
 * @author Illia Vysotski
 */

class Main {
    static JTextField jTextField1;
    static JTextField jTextField2;
    static JTextField jTextField3;
    static JLabel jLabel1;
    static JLabel jLabel2;
    static JLabel jLabel3;
    private static int value;
    private static int mortarMass;
    private static int substanceMass;
    private static int percentage;

    /**
     * creating buttons, labels and textfields
     * adding to pane
     * @param pane
     */
    public void addComponentsToPane(Container pane){
        JButton btnFindMass = new JButton("Узнать массу");
        //JButton btnFindMortarMass = new JButton("Узнать массу раствора");
        //JButton btnFindSubstanceMass = new JButton("Узнать массу сухого вещества");

        ActionListener actionListener = new MyActionListener();
        /*btnFindMortarMass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(checkInput()){
                    substanceMass = Integer.valueOf(jTextField3.getText());
                    percentage = Integer.valueOf(jTextField2.getText());
                    value = substanceMass*100/percentage;
                    jTextField1.setText("");
                    jTextField1.setText(String.valueOf(value=+value));
                }
            }
        });
        btnFindSubstanceMass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(checkInput()){
                    mortarMass = Integer.valueOf(jTextField1.getText());
                    percentage = Integer.valueOf(jTextField2.getText());
                    value = mortarMass*percentage/100;
                    jTextField3.setText("");
                    jTextField3.setText(String.valueOf(value=+value));
                }
            }
        });*/
        btnFindMass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(checkInput()){
                    mortarMass = Integer.valueOf(jTextField1.getText());
                    percentage = Integer.valueOf(jTextField2.getText());
                    substanceMass = Integer.valueOf(jTextField3.getText());

                    if (mortarMass == 0)
                    {
                        value = substanceMass*100/percentage;
                        jTextField1.setText("");
                        jTextField1.setText(String.valueOf(value=+value));
                    } else if(substanceMass == 0)
                    {
                        value = mortarMass*percentage/100;
                        jTextField3.setText("");
                        jTextField3.setText(String.valueOf(value=+value));
                    } else
                    {
                        value = substanceMass*100/mortarMass;
                        jTextField2.setText("");
                        jTextField2.setText(String.valueOf(value=+value));
                    }
                }
            }
        });

        Dimension btnDim = new Dimension(230,20);

        //btnFindMortarMass.setMinimumSize(btnDim);
        //btnFindMortarMass.setMaximumSize(btnDim);
        //btnFindSubstanceMass.setMinimumSize(btnDim);
        //btnFindSubstanceMass.setMaximumSize(btnDim);
        btnFindMass.setMinimumSize(btnDim);
        btnFindMass.setMaximumSize(btnDim);

        jTextField1 = new JTextField("0");
        jTextField1.setPreferredSize(new Dimension(30,20));
        jTextField1.setHorizontalAlignment(JTextField.LEFT);
        jTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    jLabel1.setHorizontalAlignment(jLabel1.LEFT);
                }catch (NumberFormatException e1){
                }
            }
        });
        jTextField2 = new JTextField("0");
        jTextField2.setPreferredSize(new Dimension(30,20));
        jTextField2.setHorizontalAlignment(JTextField.LEFT);
        jTextField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    jLabel2.setHorizontalAlignment(jLabel2.LEFT);
                }catch (NumberFormatException e1){

                }
            }
        });
        jTextField3 = new JTextField("0");
        jTextField3.setPreferredSize(new Dimension(30,20));
        jTextField3.setHorizontalAlignment(JTextField.LEFT);
        jTextField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    jLabel3.setHorizontalAlignment(jLabel3.LEFT);
                }catch (NumberFormatException e1){

                }
            }
        });

        jLabel1 = new JLabel("Масса раствора");
        jLabel2 = new JLabel("Процентное содержание");
        jLabel3 = new JLabel("Масса сухого вещества");

        Box box1 = Box.createVerticalBox();
        Box box2 = Box.createVerticalBox();
        Box box3 = Box.createVerticalBox();

        box1.add(Box.createRigidArea(new Dimension(10,7)));
        box1.add(jLabel1);
        box1.add(Box.createRigidArea(new Dimension(10,7)));
        box1.add(jLabel2);
        box1.add(Box.createRigidArea(new Dimension(10,7)));
        box1.add(jLabel3);

        box2.add(Box.createRigidArea(new Dimension(70,7)));
        box2.add(jTextField1);
        box2.add(Box.createRigidArea(new Dimension(70,7)));
        box2.add(jTextField2);
        box2.add(Box.createRigidArea(new Dimension(70,7)));
        box2.add(jTextField3);

        /*box3.add(Box.createRigidArea(new Dimension(10,7)));
        box3.add(btnFindMortarMass);
        box3.add(Box.createRigidArea(new Dimension(10,7)));
        box3.add(btnFindSubstanceMass);*/
        box3.add(Box.createRigidArea(new Dimension(10,7)));
        box3.add(btnFindMass);

        pane.add(box1);
        pane.add(box2);
        pane.add(box3);
    }

    /**
     *
     * @return boolean
     */
    public static boolean checkInput()
    {
        try {
            int number = Integer.valueOf(jTextField1.getText());
        } catch (NumberFormatException e1){
            jLabel1.setText("Enter the number!");
            return false;
        }
        try {
            int number = Integer.valueOf(jTextField2.getText());
        } catch (NumberFormatException e1){
            jLabel2.setText("Enter the number!");
            return false;
        }
        try {
            int number = Integer.valueOf(jTextField3.getText());
        } catch (NumberFormatException e1){
            jLabel3.setText("Enter the number!");
            return false;
        }
        return true;
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    /**
     *creating frame
     */
    public static void createGUI(){
        JFrame frame = new JFrame("Swing Demo");
        frame.setLayout(new FlowLayout());
        frame.setSize(600,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Main main = new Main();
        main.addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);

    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
}