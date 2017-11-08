import javax.swing.*;

public class buttonApply extends JButton implements CommandInterface {
    GUIAdjustments objGUIAdjustments;

    public void processEvent() {

        String applyResult = null;

        String rCode = GUIAdjustments.getSelectedCategory();
        String rDetails = GUIAdjustments.getSelectedType();

        FactoryRotate rf = FactoryRotate.getSizeFactory(rCode);

        if (rDetails.equals(GUIAdjustments.ROTATE90)) {
            Interface90 n = rf.getRotate90();
            applyResult = "Code: " + n.getRotate90() + "  Details: "
                    + n.getRotate90Details();
        }
        if (rDetails.equals(GUIAdjustments.ROTATE180)) {
            Interface180 o = rf.getRotate180();
            applyResult = "Code: " + o.getRotate180() + "  Details: "
                    + o.getRotate180Details();
        }

        System.out.println(applyResult);
        GUIAdjustments.setResult(applyResult);
    }

    public buttonApply(String name) {
        super(name);
    }
}