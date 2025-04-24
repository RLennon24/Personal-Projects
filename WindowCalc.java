import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class WindowCalc implements Runnable, ActionListener {

    private JTextArea textarea;
    private Double num1;
    private Double num2;
    private String tempactioncommand;
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Window Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createMainPanel(), BorderLayout.NORTH);
        frame.add(createSpecButtons(), BorderLayout.CENTER);
        frame.add(createButtons(), BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        textarea = new JTextArea(2, 20);
        textarea.setFont(new Font("Monospaced", Font.PLAIN, 30));
        textarea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textarea);
        panel.add(scrollPane);
        return panel;
    }

    private JPanel createSpecButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 6));
        String[] labels = {"MC", "MR", "M+", "M-", "MS", "M^"};
        for (String label : labels) {
            JButton btn = new JButton(label);
            btn.addActionListener(this);
            panel.add(btn);
        }
        return panel;
    }

    private JPanel createButtons() {
        JPanel panel = new JPanel(new GridLayout(6, 4));
        String[] labels = {
            "%", "CE", "C", "BACK",
            "1/x", "x^2", "sqrt(x)", "/",
            "7", "8", "9", "X",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
        };
        for (String label : labels) {
            JButton btn = new JButton(label);
            btn.addActionListener(this);
            panel.add(btn);
        }
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getActionCommand();

        switch (command) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
            case ".":
                textarea.append(command);
                break;

            case "/": case "X": case "+": case "-":
                String input = textarea.getText().trim();
                if (!input.isEmpty()) {
                    try {
                        num1 = Double.parseDouble(input);
                        tempactioncommand = command;
                        textarea.setText("");
                    } catch (NumberFormatException ex) {
                        textarea.setText("Error");
                    }
                }
                break;

            case "=":
                String data = textarea.getText().trim();
                if (!data.isEmpty() && num1 != null && tempactioncommand != null) {
                    try {
                        num2 = Double.parseDouble(data);
                        Double result = equalResult(num1, num2, tempactioncommand);
                        textarea.setText(String.valueOf(result));
                        num1 = null;
                        num2 = null;
                    } catch (NumberFormatException ex) {
                        textarea.setText("Error");
                    }
                }
                break;

            case "C":
                textarea.setText("");
                num1 = null;
                num2 = null;
                break;

            case "+/-":
                String inputsign = textarea.getText().trim();
                if(!inputsign.isEmpty()){
                    double value = Double.parseDouble(inputsign);
                    value= value * -1;
                    textarea.setText(String.valueOf(value));
                    
                }
                break;
                


            case "sqrt(x)":
                String input2 = textarea.getText().trim();
                if (!input2.isEmpty()) {
                    try {
                        double value = Double.parseDouble(input2);
                        if (value < 0) {
                            textarea.setText("NaN");
                        } else {
                            textarea.setText(String.valueOf(Math.sqrt(value)));
                        }
                    } catch (NumberFormatException ex) {
                        textarea.setText("Error");
                    }
                }
                break;

            case"x^2":
                String inputsq= textarea.getText().trim();
                if(!inputsq.isEmpty()){
                    try{
                        double value = Double.parseDouble(inputsq);
                        value= value* value;
                        textarea.setText(String.valueOf(value));
                    }catch(NumberFormatException ex){
                        textarea.setText("Error");
                    }
                }
                break;
            case "1/x":
                String inputdiv1= textarea.getText().trim();
                

                //FINISH

        }
    }

    public static Double equalResult(Double num1, Double num2, String op) {
        switch (op) {
            case "/":
                if (num2 == 0) return Double.NaN;
                return num1 / num2;
            case "X":
                return num1 * num2;
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new WindowCalc());
    }
}
