import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class imageOpener extends JFrame {

    public imageOpener() throws IOException {
        super("Choose an Image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel directoryLabel = new JLabel(" ");
        directoryLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
        add(directoryLabel, BorderLayout.NORTH);

        final JLabel filenameLabel = new JLabel(" ");
        filenameLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
        add(filenameLabel, BorderLayout.SOUTH);

        JFileChooser fileChooser = new JFileChooser("C://Users");
        fileChooser.setControlButtonsAreShown(false);
        add(fileChooser, BorderLayout.CENTER);

//  Create ActionListener
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser theFileChooser = (JFileChooser) actionEvent.getSource();

                String command = actionEvent.getActionCommand();

                if (command.equals(JFileChooser.APPROVE_SELECTION)) {
                    File selectedFile = theFileChooser.getSelectedFile();
                    try {
                        BufferedImage selectedImage = ImageIO.read(selectedFile);

                        //Put Image into frame
                        int width = selectedImage.getWidth();
                        int height = selectedImage.getHeight();
                        RotateTest.refreshImage(selectedImage, width, height);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //directoryLabel.setText(selectedFile.getParent());
                    //filenameLabel.setText(selectedFile.getName());
                    //System.out.println(selectedFile.getName());

                    //String selectedItem = selectedFile.getName();
                    //((DefaultListModel) GUIMain.localList.getModel()).addElement(selectedItem);

                    dispose();

                } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {

                    directoryLabel.setText(" ");
                    filenameLabel.setText(" ");
                }
            }
        };
        fileChooser.addActionListener(actionListener);


       // pack();
       // setVisible(true);
    }
}
