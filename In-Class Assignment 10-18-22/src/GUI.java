import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener{
    JPanel myPanel;
    JButton okButton, cxlButton, clearButton, addButton;
    JLabel myLabel, addLabel;
    JTextField inputField, addField1, addField2;
    public static void main(String [] args) {
        GUI window = new GUI();
        window.setTitle("My first App");
        window.setSize(1000, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public GUI() {
        myPanel = new JPanel();
        add(myPanel);
        okButton = new JButton("OK");
        cxlButton = new JButton("Cancel");
        clearButton = new JButton("Clear");
        addButton = new JButton("Add numbers");
        myPanel.add(okButton);
        myPanel.add(cxlButton);
        myPanel.add(clearButton);

        myLabel = new JLabel("Enter some text: ");
        myPanel.add(myLabel);

        inputField = new JTextField("Text? ");
        addField1 = new JTextField("Enter 1st number ");
        addField1 = new JTextField("Enter 2nd number ");
        myPanel.add(inputField);
        //myPanel.add(addField1); // these are crashing the program for some reason so i commented it out
        //myPanel.add(addField2);
        myPanel.add(addButton);

        addLabel = new JLabel("Enter numbers here to get sum: ");
        myPanel.add(addLabel);

        okButton.addActionListener(this);
        cxlButton.addActionListener(this);
        clearButton.addActionListener(this);
        addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton)  {
            inputField.setText("syrup");
        }
        else if (e.getSource() == cxlButton)  {
            inputField.setText("i aint ate");
        }
        else if (e.getSource() == clearButton) {
            inputField.setText("");
        }
        else if (e.getSource() == addButton) {
            int num1 = Integer.parseInt(addField1.getText());
            int num2 = Integer.parseInt(addField2.getText());
            addLabel.setText(String.valueOf(num1 + num2));
        }


    }
}

/* MyList.java:         12 abstract methods
MyAbstractList.java:



 */