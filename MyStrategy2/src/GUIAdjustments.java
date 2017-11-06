import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GUIAdjustments extends JFrame {

    public static final String newline = "\n";
    public static final String FILTER = "Filter";
    public static final String APPLY = "Apply";

    public static final String LARGE_SIZE = "Large";
    public static final String MEDIUM_SIZE = "Medium";
    public static final String SMALL_SIZE = "Small";

    private ButtonApply btnApply;

    private static JComboBox cmbFilterType, cmbSizeCategory, cmbSizeType;

    private static JTextField txtImageWidth, txtImageHeight;

    private static JLabel lblFilterType, lblAdjustmentsApplied,
            lblAdjustmentsAppliedValue, lblSizeCategory, lblSizeType, lblSizeName,
            lblSizeNameValue;

    public GUIAdjustments() throws IOException {
        super("Adjustments");

        //Create button-----------------------------------------------------------
        btnApply = new ButtonApply(GUIAdjustments.APPLY);
        btnApply.setMnemonic(KeyEvent.VK_A);

        ButtonHandler vf = new ButtonHandler();

        btnApply.addActionListener(vf);

        //Filter-----------------------------------------------------------------
        cmbFilterType = new JComboBox();

        lblFilterType = new JLabel("Filter Type:");
        lblAdjustmentsApplied = new JLabel("Current Adjustments:");
        lblAdjustmentsAppliedValue = new JLabel(" Please click on Apply button");

        cmbSizeCategory = new JComboBox();

        cmbSizeType = new JComboBox();
        //cmbSizeType.addItem(GUIAdjustments.LARGE_SIZE);
        //cmbSizeType.addItem(GUIAdjustments.MEDIUM_SIZE);
        //cmbSizeType.addItem(GUIAdjustments.SMALL_SIZE);

        lblSizeCategory = new JLabel("Size Category:");//currently not in use
        lblSizeType = new JLabel("Size Type:");        //but could be later
        lblSizeName = new JLabel("Apply Result:");
        lblSizeNameValue = new JLabel(" Please click on Apply button");

        txtImageHeight = new JTextField();
        txtImageWidth = new JTextField();

        ////////////////////////////////////////////////////////
        JPanel buttonPanel = new JPanel();

        //****************************************************
        buttonPanel.add(cmbFilterType);
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblFilterType, gbc);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(cmbFilterType, gbc);
        gbc.anchor = GridBagConstraints.CENTER;

        //////////////////////////////////////////////////////
        buttonPanel.add(cmbSizeCategory);
        buttonPanel.add(cmbSizeType);
        /////////////////////////////////////////////////////
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(cmbSizeCategory, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(cmbSizeType, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 6;

        //////////////////////////////////////////////////////////
        buttonPanel.add(txtImageHeight);
        buttonPanel.add(txtImageWidth);
        /////////////////////////////////////////////////////////

        gridbag.setConstraints(txtImageHeight, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gridbag.setConstraints(txtImageWidth, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 9;

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
        return (String) cmbSizeCategory.getSelectedItem();
    }

    public static String getSelectedType() {
        return (String) cmbSizeType.getSelectedItem();
    }

    public static void setResult(String ApplyResult) {
        lblSizeNameValue.setText(ApplyResult);
    }
}// end of class
