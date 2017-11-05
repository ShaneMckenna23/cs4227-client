import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver extends JFrame {

    public ImageSaver() throws IOException {
        super("Choose an Image");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setControlButtonsAreShown(true);
        fileChooser.setDialogType(fileChooser.SAVE_DIALOG);

        add(fileChooser, BorderLayout.CENTER);

//  Create ActionListener
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();

                String command = actionEvent.getActionCommand();

                if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                    File selectedFile = theFileChooser.getSelectedFile();

                    System.out.println(selectedFile.getParent());
                    System.out.println(selectedFile.getName());

                    dispose();

                } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
                    dispose();
                }
            }
        };
        fileChooser.addActionListener(actionListener);


        // pack();
        setVisible(true);
    }
}
