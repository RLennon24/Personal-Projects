import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowCalc implements Runnable, ActionListener {

    public JTextArea textarea;
    private Double num1;
    private Double num2;
    Popup p;
    JFrame frame;
    String tempactioncommand;


    @Override
    public void run() {
        JFrame frame = new JFrame("Window Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(createMainPanel(), BorderLayout.NORTH);
        frame.add(createSpecButtons(),BorderLayout.CENTER);
        frame.add(createButtons(),BorderLayout.SOUTH);


        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 100, 10, 100));
        panel.setPreferredSize(new Dimension(300, 200));

        //text area
        textarea = new JTextArea(10, 15);
        textarea.setFont(new Font("Monospaced", Font.PLAIN, 30));
        //NEED TO FIGURE OUT FONT NAME
        textarea.setCaretColor(Color.WHITE);
        textarea.setSize(0,100);
        JScrollPane scrollPane = new JScrollPane(textarea);
        panel.add(scrollPane);
        return panel;
    }
    private JPanel createSpecButtons() {
////////////create special operator buttons///////////////////
        JPanel SpecOpsPanel = new JPanel();
        SpecOpsPanel.setLayout(new GridLayout(1, 6, 0, 0));
        for (int i = 0; i < 5; i++) {
            JButton SpecButton = new JButton();
            SpecButton.setPreferredSize(new Dimension(20, 28));
            switch (i) {
                case 0:
                    SpecButton.setText("MC");
                    SpecButton.setBounds(0, 0, 15, 15);
                    SpecButton.addActionListener(this);
                    SpecOpsPanel.add(SpecButton);
                    break;
                case 1:
                    SpecButton.setText("MR");
                    SpecButton.setBounds(0, 0, 15, 15);
                    SpecButton.addActionListener(this);
                    SpecOpsPanel.add(SpecButton);
                    break;
                case 2:
                    SpecButton.setText("M+");
                    SpecButton.setBounds(0, 0, 15, 15);
                    SpecButton.addActionListener(this);
                    SpecOpsPanel.add(SpecButton);
                    break;
                case 3:
                    SpecButton.setText("M-");
                    SpecButton.setBounds(0, 0, 15, 15);
                    SpecButton.addActionListener(this);
                    SpecOpsPanel.add(SpecButton);
                    break;
                case 4:
                    SpecButton.setText("MS");
                    SpecButton.setBounds(0, 0, 15, 15);
                    SpecButton.addActionListener(this);
                    SpecOpsPanel.add(SpecButton);
                    break;
                case 5:
                    SpecButton.setText("M^");
                    SpecButton.setBounds(0, 0, 15, 15);
                    SpecButton.addActionListener(this);
                    SpecOpsPanel.add(SpecButton);
                    break;
            }

        }
        return SpecOpsPanel;
    }




    private JPanel createButtons() {
///////////////////create number and operator buttons///////////////////////////
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 0,0,0));
        for (int i = 0; i < 24; i++) {
            JButton button = new JButton();
            switch (i) {
                case 0:
                    button.setText("%");
                    button.setBounds(0,0,15,15);
                    button.addActionListener(this);
                    button.setActionCommand("%");
                    buttonPanel.add(button);
                    //button.revalidate();
                    break;
                case 1:
                    button.setText("CE");
                    button.setPreferredSize(new Dimension(15,15));
                    button.addActionListener(this);
                    button.setActionCommand("CE");
                    buttonPanel.add(button);
                    //button.revalidate();
                    break;
                case 2:
                    button.setText("C");
                    button.setPreferredSize(new Dimension(15,15));
                    button.addActionListener(this);
                    button.setActionCommand("C");
                    buttonPanel.add(button);
                    break;
                case 3:
                    button.setText("BACK");
                    button.setPreferredSize(new Dimension(15,15));
                    button.addActionListener(this);
                    button.setActionCommand("BACK");
                    buttonPanel.add(button);
                    break;
                case 4:
                    button.setText("1/x");
                    button.setPreferredSize(new Dimension(15,15));
                    button.addActionListener(this);
                    button.setActionCommand("1/x");
                    buttonPanel.add(button);
                    break;
                case 5:
                    button.setText("x^2");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("x^2");
                    buttonPanel.add(button);
                    break;
                case 6:
                    button.setText("sqrt(x)");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("sqrt(x)");
                    buttonPanel.add(button);
                    break;
                case 7:
                    button.setText("/");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("/");
                    buttonPanel.add(button);
                    break;
                case 8:
                    button.setText("7");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("7");
                    buttonPanel.add(button);
                    break;
                case 9:
                    button.setText("8");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("8");
                    buttonPanel.add(button);
                    break;
                case 10:
                    button.setText("9");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("9");
                    buttonPanel.add(button);
                    break;
                case 11:
                    button.setText("X");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("X");
                    buttonPanel.add(button);
                    break;
                case 12:
                    button.setText("4");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("4");
                    buttonPanel.add(button);
                    break;
                case 13:
                    button.setText("5");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("5");
                    buttonPanel.add(button);
                    break;
                case 14:
                    button.setText("6");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("6");
                    buttonPanel.add(button);
                    break;
                case 15:
                    button.setText("-");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("-");
                    buttonPanel.add(button);
                    break;
                case 16:
                    button.setText("1");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("1");
                    buttonPanel.add(button);
                    break;
                case 17:
                    button.setText("2");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("2");
                    buttonPanel.add(button);
                    break;
                case 18:
                    button.setText("3");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("3");
                    buttonPanel.add(button);
                    break;
                case 19:
                    button.setText("+");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("+");
                    buttonPanel.add(button);
                    break;
                case 20:
                    button.setText("+/-");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("+/-");
                    buttonPanel.add(button);
                    break;
                case 21:
                    button.setText("0");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("0");
                    buttonPanel.add(button);
                    break;
                case 22:
                    button.setText(".");
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand(".");
                    buttonPanel.add(button);
                    break;
                case 23:
                    button.setText("=");
                    button.setBackground(Color.BLUE);
                    button.setForeground(Color.WHITE);
                    button.setPreferredSize(new Dimension(50,50));
                    button.addActionListener(this);
                    button.setActionCommand("=");
                    buttonPanel.add(button);
                    break;
            }

        }
        return buttonPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand=  ((JButton) e.getSource()).getActionCommand();
        JOptionPane error = new JOptionPane();
        PopupFactory pf=new PopupFactory();
        JPanel errorPan= new JPanel();
        errorPan.add(error);
        p= pf.getPopup(frame,errorPan, 180,100);

        switch(actionCommand){
            case "MC":
                break;
            case "MR":
                break;
            case "M+":
                break;
            case "M-":
                break;
            case "MS":
                break;
            case "M^":
                break;
            case "%":
                break;
            case "CE":
                break;
            case "C":
                break;
            case "1/x":
                break;
            case "x^2":
                break;
            case "sqrt(x)":
                break;
            case "/":
                String data= textarea.getText().trim();
                tempactioncommand= ((JButton) e.getSource()).getActionCommand();
                if(data.length()>0) {
                    if (num1 == null) {
                        num1 = (Double) Double.parseDouble(data);
                        textarea.setText("");
                        System.out.println(num1);
                    } else {
                        error.showMessageDialog(frame, "Please enter a number");
                    }
                }
                break;
            case "7":
                textarea.append("7");
                break;
            case "8":
                textarea.append("8");
                break;
            case "9":
                textarea.append("9");
                break;
            case "x":
                tempactioncommand= ((JButton) e.getSource()).getActionCommand();
                break;
            case "4":
                textarea.append("4");
                break;
            case "5":
                textarea.append("5");
                break;
            case "6":
                textarea.append("6");
                break;
            case "-":
                tempactioncommand= ((JButton) e.getSource()).getActionCommand();
                break;
            case "1":
                textarea.append("1");
                System.out.println(1);
                break;
            case "2":
                textarea.append("2");
                break;
            case "3":
                textarea.append("3");
                break;
            case "+":
                tempactioncommand= ((JButton) e.getSource()).getActionCommand();
                break;
            case "+/-":

                break;
            case "0":
                textarea.append("0");
                break;
            case ".":
                textarea.append(".");
                break;
            case "=":
                String result= equalResult(num1,num2,tempactioncommand).toString();
                textarea.setText(result);
                }

        }
        }
    public static Double equalResult(Double num1,Double num2, String tempactioncommand) {
    double result = 0.0;
        switch(tempactioncommand){
            case "/":
                result= (num1/num2);
    }
        return (Double) result;

    }


    public void main(String[] args) {
        //add method call
        SwingUtilities.invokeLater(new WindowCalc());

    }

}