import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            Model model = new Model();
            new Control(model, view);
            view.setVisible(true);
        });
    }
}