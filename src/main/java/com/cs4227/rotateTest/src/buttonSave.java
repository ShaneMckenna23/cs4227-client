import javax.swing.*;

class buttonSave extends JButton implements CommandInterface {

    public void processEvent() {

        System.out.println("Save");
    }

    public buttonSave(String name) {
        super(name);
    }
}