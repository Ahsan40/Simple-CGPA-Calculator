package calculator.cgpa;

public class MainController {
    public static void main(String[] args) {
        // start gui
        java.awt.EventQueue.invokeLater(() -> new MainGui().setVisible(true));
//        System.out.println(Thread.currentThread().getId()); // debug
    }
}
