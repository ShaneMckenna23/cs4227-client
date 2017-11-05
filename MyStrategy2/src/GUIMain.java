import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GUIMain extends JFrame {

    public static final String newline = "\n";
    public static final String OPEN = "Open";
    public static final String SAVE = "Save";
    public static final String UNDO = "Undo";
    public static final String REDO = "Redo";
    public static final String INFO = "Info"; //present info about image opened
    public static final String HELP = "Help"; //present info on tools
    public static final String EXIT = "Exit";

    private ButtonOpen btnOpen;
    private ButtonSave btnSave;
    private ButtonUndo btnUndo;
    private ButtonRedo btnRedo;
    private ButtonInfo btnInfo;
    private ButtonHelp btnHelp;

    private JPanel pnlGUIMain;

    public GUIMain() throws Exception {
        super("Main");

        // Create controls
        pnlGUIMain = new JPanel();

        //Create buttons
        btnOpen = new ButtonOpen(GUIMain.OPEN);
        btnOpen.setMnemonic(KeyEvent.VK_O);
        btnSave = new ButtonSave(GUIMain.SAVE);
        btnSave.setMnemonic(KeyEvent.VK_S);
        btnUndo = new ButtonUndo(GUIMain.UNDO);
        btnUndo.setMnemonic(KeyEvent.VK_U);
        btnRedo = new ButtonRedo(GUIMain.REDO);
        btnRedo.setMnemonic(KeyEvent.VK_R);
        btnInfo = new ButtonInfo(GUIMain.INFO);
        btnInfo.setMnemonic(KeyEvent.VK_I);
        btnHelp = new ButtonHelp(GUIMain.HELP);
        btnHelp.setMnemonic(KeyEvent.VK_H);
        ButtonExit btnExit = new ButtonExit(GUIMain.EXIT);
        btnExit.setMnemonic(KeyEvent.VK_X);

        ButtonHandler vf = new ButtonHandler();

        btnOpen.addActionListener(vf);
        btnSave.addActionListener(vf);
        btnUndo.addActionListener(vf);
        btnRedo.addActionListener(vf);
        btnInfo.addActionListener(vf);
        btnHelp.addActionListener(vf);
        btnExit.addActionListener(vf);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //-----------------------------------
        //Button Panel
        JPanel buttonPanel = new JPanel();

        //----------------------------------------------
        GridBagLayout gridbag = new GridBagLayout();//Gridbage spaces out the layout
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(btnOpen);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnUndo);
        buttonPanel.add(btnRedo);
        buttonPanel.add(btnInfo);
        buttonPanel.add(btnHelp);
        buttonPanel.add(btnExit);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(btnOpen, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gridbag.setConstraints(btnSave, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gridbag.setConstraints(btnUndo, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gridbag.setConstraints(btnRedo, gbc);
        gbc.gridx = 5;
        gbc.gridy = 0;
        gridbag.setConstraints(btnInfo, gbc);
        gbc.gridx = 6;
        gbc.gridy = 0;
        gridbag.setConstraints(btnHelp, gbc);
        gbc.gridx = 7;
        gbc.gridy = 0;
        gridbag.setConstraints(btnExit, gbc);

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
