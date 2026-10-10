
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ZooFrame zooFrame = new ZooFrame();
            zooFrame.setVisible(true);
        });

    }
}
