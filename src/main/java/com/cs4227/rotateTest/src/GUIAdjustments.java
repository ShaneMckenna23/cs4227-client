import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GUIAdjustments extends JFrame {

    public static final String newline = "\n";
    public static final String APPLY = "Apply";

    public static final String ROTATE90 = "Rotate 90";
    public static final String ROTATE180 = "Rotate 180";

    private buttonApply btnApply;

    private static JComboBox cmbRotateDirection, cmbRotateDegree;

    private static JLabel lblAdjustmentsApplied, lblAdjustmentsAppliedValue, 
            lblRotateDirection, lblRotateDegree, lblRotateType, lblRotateTypeValue;

    public GUIAdjustments() throws IOException {
        super("Adjustments");

        //Create button-----------------------------------------------------------
        btnApply = new buttonApply(GUIAdjustments.APPLY);
        btnApply.setMnemonic(KeyEvent.VK_A);

        buttonHandler vf = new buttonHandler();

        btnApply.addActionListener(vf);

        lblAdjustmentsApplied = new JLabel("Current Adjustments:");
        lblAdjustmentsAppliedValue = new JLabel(" Please click on Apply button");

        cmbRotateDirection = new JComboBox();
        cmbRotateDirection.addItem(FactoryRotate.CLOCKWISE);
        cmbRotateDirection.addItem(FactoryRotate.ANTICLOCKWISE);

        cmbRotateDegree = new JComboBox();
        cmbRotateDegree.addItem(GUIAdjustments.ROTATE90);
        cmbRotateDegree.addItem(GUIAdjustments.ROTATE180);

        lblRotateDirection = new JLabel("Rotate Direction:");//currently not in use
        lblRotateDegree = new JLabel("Rote Degrees:");        //but could be later
        lblRotateType = new JLabel("Apply Result:");
        lblRotateTypeValue = new JLabel(" Please click on Apply button");

        ////////////////////////////////////////////////////////
        JPanel buttonPanel = new JPanel();

        //****************************************************
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        //////////////////////////////////////////////////////
        buttonPanel.add(cmbRotateDirection);
        buttonPanel.add(cmbRotateDegree);
        /////////////////////////////////////////////////////
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(cmbRotateDirection, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(cmbRotateDegree, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;

        buttonPanel.add(btnApply);
        gridbag.setConstraints(btnApply, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        /////////////////////////////////////////////////////

        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    public static String getSelectedCategory() {
        return (String) cmbRotateDirection.getSelectedItem();
    }

    public static String getSelectedType() {
        return (String) cmbRotateDegree.getSelectedItem();
    }

    public static void setResult(String ApplyResult) {
        lblRotateTypeValue.setText(ApplyResult);
    }
}// end of class
