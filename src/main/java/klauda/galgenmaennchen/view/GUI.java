package klauda.galgenmaennchen.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static klauda.galgenmaennchen.FileReader.fileReader;
import static klauda.galgenmaennchen.Functions.randomNumber;
import static klauda.galgenmaennchen.Functions.repeatTurn;

public class GUI extends JFrame {


//    public GUI() {
//        JFrame frame = new JFrame();
//        frame.setSize(800,400);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JTextArea text = new JTextArea();
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(0,1));
//        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
//        panel.add(text);
//
//        frame.add(panel,BorderLayout.CENTER);
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new GUI();
//    }

    private JTextArea console;

    private JTextArea output;
    private JTextField input;

    public GUI() {
        super("Text Field Example");

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField();

        panel.add(label, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.NORTH);

        output = new JTextArea();
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setVisible(true);

        textField.addActionListener(e -> {
            String text = textField.getText();
            System.out.println("Your name is: " + text);
            output.append("Your name is: " + text);
            textField.setText("");
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}