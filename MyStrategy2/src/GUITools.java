import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GUITools extends JFrame {

    public static final String newline = "\n";
    public static final String BONE = "B1";
    public static final String BTWO = "B2";
    public static final String BTHREE = "B3";
    public static final String BFOUR = "B4";
    public static final String BFIVE = "B5";
    public static final String BSIX = "B6";

    private ButtonEmpty btnBOne;
    private ButtonEmpty btnBTwo;
    private ButtonEmpty btnBThree;
    private ButtonEmpty btnBFour;
    private ButtonEmpty btnBFive;
    private ButtonEmpty btnBSix;

    private JPanel pnlGUITools;

    public GUITools() throws Exception {
        super("Tools");

        // Create controls
        pnlGUITools = new JPanel();

        //Create buttons
        btnBOne = new ButtonEmpty(GUITools.BONE);
        btnBOne.setMnemonic(KeyEvent.VK_O);
        btnBTwo = new ButtonEmpty(GUITools.BTWO);
        btnBTwo.setMnemonic(KeyEvent.VK_T);
        btnBThree = new ButtonEmpty(GUITools.BTHREE);
        btnBThree.setMnemonic(KeyEvent.VK_U);
        btnBFour = new ButtonEmpty(GUITools.BFOUR);
        btnBFour.setMnemonic(KeyEvent.VK_F);
        btnBFive = new ButtonEmpty(GUITools.BFIVE);
        btnBFive.setMnemonic(KeyEvent.VK_G);
        btnBSix = new ButtonEmpty(GUITools.BSIX);
        btnBSix.setMnemonic(KeyEvent.VK_S);

        ButtonHandler vf = new ButtonHandler();

        btnBOne.addActionListener(vf);
        btnBTwo.addActionListener(vf);
        btnBThree.addActionListener(vf);
        btnBFour.addActionListener(vf);
        btnBFive.addActionListener(vf);
        btnBSix.addActionListener(vf);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //-----------------------------------
        //Button Panel
        JPanel buttonPanel = new JPanel();

        //----------------------------------------------
        GridBagLayout gridbag = new GridBagLayout();//Gridbage spaces out the layout
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(btnBOne);
        buttonPanel.add(btnBTwo);
        buttonPanel.add(btnBThree);
        buttonPanel.add(btnBFour);
        buttonPanel.add(btnBFive);
        buttonPanel.add(btnBSix);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(btnBOne, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gridbag.setConstraints(btnBTwo, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gridbag.setConstraints(btnBThree, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(btnBFour, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gridbag.setConstraints(btnBFive, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gridbag.setConstraints(btnBSix, gbc);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);

    }
}// end of class
