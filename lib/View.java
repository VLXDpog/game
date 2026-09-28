import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.*;

public class View extends JFrame{

    public View() {
    super("Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout(5, 5));

    JTextField display = new JTextField("0");
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);
    add(display, BorderLayout.NORTH);

    JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 4, 4));

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton();
    JButton b0 = new JButton();
    JButton mul = new JButton();
    JButton div = new JButton();
    JButton sum = new JButton();
    JButton minus= new JButton();
    JButton equal = new JButton();
    JButton cancel = new JButton();

    JButton [] buttons = {  b7, b8, b9, div,
                            b4, b5, b6, mul,
                            b1, b2, b3, minus,
                            cancel, b0, equal, sum};
    String[] labels = {     "7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "C", "0", "=", "+" };
    
    for(int i = 0; i < buttons.length; i++){
        buttons[i].setText(labels[i]);
        buttonPanel.add(buttons[i]);
    }

    add(buttonPanel, BorderLayout.CENTER);
    pack();
    setLocationRelativeTo(null);

}

}
