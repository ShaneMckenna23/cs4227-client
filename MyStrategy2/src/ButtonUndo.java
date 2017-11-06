import javax.swing.*;

class ButtonUndo extends JButton implements CommandInterface {

    public void processEvent() {

        System.out.println("Undo");
    }

    public ButtonUndo(String name) {
        super(name);
    }
}