import javax.swing.*;

public class ButtonExit extends JButton implements CommandInterface {

    public void processEvent() {
        System.exit(1);
    }

    public ButtonExit(String name) {
        super(name);
    }
}