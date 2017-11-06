import javax.swing.*;

class ButtonRedo extends JButton implements CommandInterface {

    public void processEvent() {

        System.out.println("Redo");
    }

    public ButtonRedo(String name) {
        super(name);
    }
}