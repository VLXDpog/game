import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class Control implements ActionListener {
    private final Model model;
    private final View view;

    private double operand1 = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public Control (Model model, View view){
        this.model = model;
        this.view = view;
        for (JButton b : view.getButtons()) {
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd.matches("[0-9]")){
            handleDigit(cmd);
        } else if(cmd.equals("C")){
            handleClear();
        } else if(cmd.equals("=")){
            handleEquals();
        } else {
            handleOperator(cmd);
        }
    }

    private void handleDigit(String digit){
        if (startNewNumber || view.getDisplayText().equals("0")){
            view.setDisplayText(digit);
            startNewNumber = false;
        } else {
            view.setDisplayText(view.getDisplayText() + digit);
        }
    }

    private void handleOperator (String op){
        if (!operator.isEmpty() && !startNewNumber) {
            handleEquals();
        }

        operand1 = readDisplay();
        operator = op;
        startNewNumber = true;

    }

    private void handleClear() {
        operand1 = 0;
        operator = "";
        startNewNumber = true;
        view.setDisplayText("0");
    }

    private void handleEquals() {
        if (operator.isEmpty()) return;

        double operand2 = readDisplay();
        try {
            double result = model.calculate(operand1, operand2, operator);
            view.setDisplayText(format(result));
            operand1 = result;
        } catch (ArithmeticException ex) {
            view.setDisplayText("Lỗi");
            operand1 = 0;
        }
        operator = "";
        startNewNumber = true;
    }

    private double readDisplay() {
        try{
            return Double.parseDouble(view.getDisplayText());
        } catch (NumberFormatException ex){
            return 0;
        }
    }

    private String format(double value) {
        if(value == (long) value){
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
