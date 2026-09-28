import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.*;

public class View extends JFrame {

    private JTextField display = new JTextField("0");
    private JButton[] buttons;

    public View() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // Dùng field display có sẵn, không khai báo lại
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 4, 4));

        String[] labels = { "7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "C", "0", "=", "+" };

        // Gán vào field buttons, không có chữ JButton[] ở đầu
        buttons = new JButton[labels.length];
        for (int i = 0; i < labels.length; i++) {
            buttons[i] = new JButton(labels[i]);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public JButton[] getButtons() { return buttons; }
    public String getDisplayText() { return display.getText(); }
    public void setDisplayText(String text) { display.setText(text); }
}