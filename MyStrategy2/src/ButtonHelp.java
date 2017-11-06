import javax.swing.*;

class ButtonHelp extends JButton implements CommandInterface {

    public void processEvent() {

        System.out.println("Help");
    }

    public ButtonHelp(String name) {
        super(name);
    }
}