import javax.swing.SwingUtilities;
import view.AlunoForm;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AlunoForm().setVisible(true);
        });
    }
}
