import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUIImageViewer extends JFrame {

    public static BufferedImage selectedImage;
    public static int width, height;

    public GUIImageViewer(BufferedImage image, int w, int h) throws Exception {
        super("Image Viewer");

        selectedImage = image;
        width = w;
        height = h;
        //****************************************************
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        //------------------------------------------------------

        //System.out.println("Worked");
        JLabel actualImage = new JLabel(new ImageIcon(selectedImage));

        //****************************************************

        //Add the image to the frame
        Container contentPane = getContentPane();
        contentPane.add(actualImage, BorderLayout.CENTER);
    }
}// end of class
