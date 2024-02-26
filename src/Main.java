import javax.swing.UIManager;
import view.IntroduceView;

public class Main {
    public static void main(String[] args) {
        try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new IntroduceView();
        } catch (Exception e) {
        }
    }
}  
