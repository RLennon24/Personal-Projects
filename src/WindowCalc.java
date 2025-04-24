import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowCalc implements Runnable, ActionListener {

    public JTextArea textarea;
    private Double num1;
    private Double num2;
    String tempactioncommand;
    JFrame frame;

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
        textarea = new JTextArea(10, 15);
        textarea.setFont(new Font("Monospaced", Font.PLAIN, 30));
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
                    num1 = Double.parseDouble(input);
                    tempactioncommand = command;
                    textarea.setText("");
                }
                break;

            case "=":
                String data = textarea.getText().trim();
                if (!data.isEmpty()) {
                    num2 = Double.parseDouble(data);
                    Double result = equalResult(num1, num2, tempactioncommand);
                    textarea.setText(String.valueOf(result));
                    num1 = null; // Reset for next operation
                    num2 = null;
                }
                break;

            case "C":
                textarea.setText("");
                num1 = null;
                num2 = null;
                break;
            

            case "sqrt(x)":
                
                String input2 = textarea.getText().trim();
                double doubleValue = Double.parseDouble(input2);
                Math.sqrt(doubleValue);
                

            // Add other operations as needed...
        }}
    }

    public static Double equalResult(Double num1, Double num2, String op) {
        switch (op) {
            case "/": return num1 / num2;
            case "X": return num1 * num2;
            case "+": return num1 + num2;
            case "-": return num1 - num2;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new WindowCalc());
    }
