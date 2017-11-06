import javax.swing.*;

public class ButtonApply extends JButton implements CommandInterface {
    GUIAdjustments objGUIAdjustments;

    public void processEvent() {

        System.out.println("Apply Button");
    }

    public ButtonApply(String name) {
        super(name);
    }
}