import javax.swing.*;

class ButtonInfo extends JButton implements CommandInterface {

    public void processEvent() {

        System.out.println("Info");
    }

    public ButtonInfo(String name) {
        super(name);
    }
}