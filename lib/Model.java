public class Model {
    public double calculate(double a, double b, String op){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if(b == 0) throw new ArithmeticException("Cannot divided by 0");
                return a / b;
            default:
                throw new IllegalArgumentException("Not valid");
        }
    }
}
