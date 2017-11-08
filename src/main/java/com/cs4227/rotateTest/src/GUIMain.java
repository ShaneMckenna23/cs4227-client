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

    private buttonOpen btnOpen;
    private buttonSave btnSave;

    private JPanel pnlGUIMain;

    public GUIMain() throws Exception {
        super("Main");

        // Create controls
        pnlGUIMain = new JPanel();

        //Create buttons
        btnOpen = new buttonOpen(GUIMain.OPEN);
        btnOpen.setMnemonic(KeyEvent.VK_O);
        btnSave = new buttonSave(GUIMain.SAVE);
        btnSave.setMnemonic(KeyEvent.VK_S);

        buttonHandler vf = new buttonHandler();

        btnOpen.addActionListener(vf);
        btnSave.addActionListener(vf);

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
