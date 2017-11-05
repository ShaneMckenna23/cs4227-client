import javax.swing.*;

class ButtonEmpty extends JButton implements CommandInterface {

    public void processEvent() {

        System.out.println("Empty Button");
    }

    public ButtonEmpty(String name) {
        super(name);
    }
}